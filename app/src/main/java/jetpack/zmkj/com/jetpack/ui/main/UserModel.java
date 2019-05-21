package jetpack.zmkj.com.jetpack.ui.main;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceAnnotation;
import com.nirvana.ylmc.httplib.myOkhttp.RxSchedulerHelper;

import jetpack.zmkj.com.jetpack.http.CustomerService;
import jetpack.zmkj.com.jetpack.http.MyObserver;

public class UserModel extends BaseModel implements IUserModel {


    @HttpServiceAnnotation
    CustomerService customerService;

    @Override
    public void login(String username, String password, final LoginListener loginListener) {

        try {
            Thread.sleep(1000);
            UserEntity userEntity = new UserEntity("li", "jianjun");
            loginListener.onSuccess(userEntity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mRxManager.add(customerService.login(username, password)
                .compose(RxSchedulerHelper.<UserEntity>io_main())
                .subscribe(new MyObserver<UserEntity>() {
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
                }));
    }

}
