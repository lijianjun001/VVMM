package jetpack.zmkj.com.jetpack.ui.main;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import jetpack.zmkj.com.jetpack.CustomApplication;
import jetpack.zmkj.com.jetpack.MyWork;
import jetpack.zmkj.com.jetpack.http.UserEntity;

public class MainViewModel extends ViewModel implements LoginListener {

    private UserModel userModel;
    private DataSource.Factory<Integer, User> userFactory =
            CustomApplication.getInstance().getAppDatabase().userDao().getUsers();

    LiveData<PagedList<User>> userList;

    public MainViewModel() {
        userModel = new UserModel();//如果以后更换请求方式，直接修改这个地方即可，

        userList = new LivePagedListBuilder<>(userFactory, 10).build();
    }

    private MutableLiveData<UserEntity> userMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<UserEntity> getUserMutableLiveData() {
        return userMutableLiveData;
    }


    public void login(String username, String password) {

        userModel.login(username, password, this);
    }

    public void getVCode(String telephone) {
        userModel.getVCode(telephone);
    }

    public void getGoods(String telephone) {
        userModel.getGoods("");
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
    public void onSuccess(UserEntity user) {//登陆成功回调
        userMutableLiveData.postValue(user);//使用MutableLiveData,使model和view解耦
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        userModel.onClear();
    }
}
