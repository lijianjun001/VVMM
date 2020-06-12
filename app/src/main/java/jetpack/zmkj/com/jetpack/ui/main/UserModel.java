package jetpack.zmkj.com.jetpack.ui.main;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceAnnotation;
import com.nirvana.ylmc.httplib.myOkhttp.ResultModel;
import com.nirvana.ylmc.httplib.myOkhttp.RxSchedulerHelper;

import jetpack.zmkj.com.jetpack.http.CustomerService;
import jetpack.zmkj.com.jetpack.http.MyObserver;
import jetpack.zmkj.com.jetpack.http.UserEntity;

public class UserModel extends BaseModel implements IUserModel {


    @HttpServiceAnnotation
    private CustomerService customerService;


    @Override
    public void login(String username, String password, final LoginListener loginListener) {
        mRxManager.add(customerService.login(username, password)
                .compose(RxSchedulerHelper.<ResultModel<UserEntity>>io_main())
                .subscribe(new MyObserver<ResultModel<UserEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResultModel<UserEntity> user) {
                        loginListener.onSuccess(user.getDatas());
                    }
                }));
    }

}
