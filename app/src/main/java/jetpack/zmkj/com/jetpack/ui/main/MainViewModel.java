package jetpack.zmkj.com.jetpack.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel implements LoginListener {

    private IUserModel userModel;


    private MutableLiveData<UserEntity> userMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<UserEntity> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public MainViewModel() {
        userModel=new UserModel();//如果以后更换请求方式，直接修改这个地方即可，
    }


    public void login(String username, String password) {

        userModel.login(username, password, this);
    }

    @Override
    public void onSuccess(UserEntity userEntity) {//登陆成功回调
        userMutableLiveData.postValue(userEntity);//使用MutableLiveData,使model和view解耦
    }
}
