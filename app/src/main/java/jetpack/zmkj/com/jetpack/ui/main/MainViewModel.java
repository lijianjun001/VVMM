package jetpack.zmkj.com.jetpack.ui.main;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import jetpack.zmkj.com.jetpack.CustomApplication;

public class MainViewModel extends ViewModel implements LoginListener {

    private UserModel userModel;
    private DataSource.Factory<Integer, User> userFactory =
            CustomApplication.getInstance().getAppDatabase().userDao().getUsers();

    LiveData<PagedList<User>> userList;

    public MainViewModel() {
        userModel = new UserModel();//如果以后更换请求方式，直接修改这个地方即可，

        userList = new LivePagedListBuilder<>(userFactory, 10).build();


    }

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<User> getUserMutableLiveData() {
        return userMutableLiveData;
    }


    public void login(String username, String password) {

        userModel.login(username, password, this);
    }

    @Override
    public void onSuccess(User user) {//登陆成功回调
        userMutableLiveData.postValue(user);//使用MutableLiveData,使model和view解耦
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        userModel.onClear();
    }
}
