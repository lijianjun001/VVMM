package jetpack.zmkj.com.jetpack.ui.main;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import jetpack.zmkj.com.jetpack.CustomApplication;
import jetpack.zmkj.com.jetpack.MyWork;
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

        userModel.login(username, password, this);
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

    /**
     * workmanager 条件满足时候执行 或者 app重新启动时候执行，app杀死后，work也不会执行，网上说的有问题，亲自测试多次
     */

    public LiveData<Operation.State> startWork() {


        Data data = new Data.Builder().putString("key", "1111").build();
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresBatteryNotLow(true).build();
        WorkRequest request = new OneTimeWorkRequest.Builder(MyWork.class).setInputData(data).setConstraints(constraints).build();
        return WorkManager.getInstance().enqueue(request).getState();

    }

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
}
