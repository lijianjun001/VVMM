package jetpack.zmkj.com.jetpack.ui.main;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import jetpack.zmkj.com.jetpack.CustomApplication;
import jetpack.zmkj.com.jetpack.http.AddressListModel;
import jetpack.zmkj.com.jetpack.http.BuyIngDetailVoEntity;
import jetpack.zmkj.com.jetpack.http.BuyIngDetailVoModel;
import jetpack.zmkj.com.jetpack.http.CouponModel;
import jetpack.zmkj.com.jetpack.http.GoodsDetail;
import jetpack.zmkj.com.jetpack.http.HomeDataModel;
import jetpack.zmkj.com.jetpack.http.LoginModel;

public class MainViewModel extends ViewModel implements LoginListener, LifecycleEventObserver {

    private UserModel userModel;
    private DataSource.Factory<Integer, User> userFactory =
            CustomApplication.getInstance().getAppDatabase().userDao().getUsers();


    public MainViewModel() {
        userModel = new UserModel();//如果以后更换请求方式，直接修改这个地方即可，
        EventBus.getDefault().register(this);
    }

    private MutableLiveData<LoginModel> userMutableLiveData = new MutableLiveData<>();


    public MutableLiveData<LoginModel> getUserMutableLiveData() {
        return userMutableLiveData;
    }


    public void login(String username, String password) {

        userModel.login(username, password);
    }

    public void getVCode(String telephone) {
        userModel.getVCode(telephone);
    }

    public void getGoods() {
        LoginModel loginModel = userMutableLiveData.getValue();

        userModel.getGoods(loginModel.getUser().getUid(), loginModel.getSid());
    }


    public void getGoodsDetail() {
        LoginModel loginModel = userMutableLiveData.getValue();

        userModel.getGoodsDetail(loginModel.getUser().getUid(), loginModel.getSid(), homeDataModel.getHomeData().getBanner().get(0).getBizId());
    }

    public void getAddress() {
        LoginModel loginModel = userMutableLiveData.getValue();

        userModel.getAddress(loginModel.getUser().getUid(), loginModel.getSid());
    }

    public void preCreateOrder() {
        LoginModel loginModel = userMutableLiveData.getValue();
        userModel.preCreateOrder(goodsDetail.getGoodsDetail().getSpec().get(0).getRefPid(), 1, loginModel.getUser().getUid(), loginModel.getSid());
    }

    public void getCoupon() {
        LoginModel loginModel = userMutableLiveData.getValue();
        BuyIngDetailVoEntity buyIngDetailVoEntity = buyIngDetailVoModel.getBuyIngDetailVo();
        userModel.getCouponList(buyIngDetailVoEntity.getGoods(), loginModel.getUser().getUid(), loginModel.getSid());

    }

    public void createOrder() {
//        BuyIngDetailVoEntity buyIngDetailVoEntity = buyIngDetailVoModel.getBuyIngDetailVo();
//        LoginModel loginModel = userMutableLiveData.getValue();
//        String couponId = "";
//        List<CouponEntity> couponEntities = couponModel.getCouponList();
//        if (couponEntities != null && couponEntities.size() > 0) {
//            couponId = couponEntities.get(0).getId();
//        }
        for (Map.Entry<String, CreateOrderModel2> entry : UserModel.createOrderModel2HashMap.entrySet()) {
            CreateOrderModel2 createOrderModel2 = entry.getValue();
            userModel.createOrder(createOrderModel2.getAddressModel(), createOrderModel2.getGoods(), createOrderModel2.getFreight(), createOrderModel2.getTotalFee(), createOrderModel2.getAddressId(), null, createOrderModel2.getTeaCouponId(), "0", createOrderModel2.getUid(), createOrderModel2.getSid());
        }
    }

    /**
     * workmanager 条件满足时候执行 或者 app重新启动时候执行，app杀死后，work也不会执行，网上说的有问题，亲自测试多次
     */

//    public LiveData<Operation.State> startWork() {
//        Data data = new Data.Builder().putString("key", "1111").build();
//        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresBatteryNotLow(true).build();
//        WorkRequest request = new OneTimeWorkRequest.Builder(MyWork.class).setInputData(data).setConstraints(constraints).build();
//        return WorkManager.getInstance().enqueue(request).getState();
//
//    }

    @Override
    public void onSuccess(LoginModel loginModel) {//登陆成功回调

        userMutableLiveData.postValue(loginModel);//使用MutableLiveData,使model和view解耦
    }

    private HomeDataModel homeDataModel;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(HomeDataModel homeDataModel) {

        this.homeDataModel = homeDataModel;
    }

    private GoodsDetail goodsDetail;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(GoodsDetail goodsDetail) {

        this.goodsDetail = goodsDetail;
    }

    private AddressListModel addressListModel;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(AddressListModel addressListModel) {

        this.addressListModel = addressListModel;
    }


    private BuyIngDetailVoModel buyIngDetailVoModel;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(BuyIngDetailVoModel buyIngDetailVoModel) {

        this.buyIngDetailVoModel = buyIngDetailVoModel;
    }


    private CouponModel couponModel;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(CouponModel couponModel) {

        this.couponModel = couponModel;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        userModel.onClear();
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {

        if (event == Lifecycle.Event.ON_DESTROY) {
            EventBus.getDefault().unregister(this);
        }
    }


    public void preCreatOrder() {


    }

}
