package jetpack.zmkj.com.jetpack.ui.main;

import com.nirvana.ylmc.httplib.myOkhttp.RxSchedulerHelper;

import jetpack.zmkj.com.jetpack.http.CustomerService;
import jetpack.zmkj.com.jetpack.http.HttpServiceManager;
import rx.Observer;

public class UserModel implements IUserModel {

    @Override
    public void login(String username, String password, final LoginListener loginListener) {

        try {
            Thread.sleep(1000);
            UserEntity userEntity =new UserEntity("li","jianjun");
            loginListener.onSuccess(userEntity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HttpServiceManager.getInstance().configRetrofit(CustomerService.class).login(username, password)
                .compose(RxSchedulerHelper.<UserEntity>io_main())
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        loginListener.onSuccess(userEntity);
                    }
                });
    }

}
