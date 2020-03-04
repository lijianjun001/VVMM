package jetpack.zmkj.com.jetpack.ui.main;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceAnnotation;
import com.nirvana.ylmc.httplib.myOkhttp.RxSchedulerHelper;

import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;
import io.reactivex.Observable;
import jetpack.zmkj.com.jetpack.CustomApplication;
import jetpack.zmkj.com.jetpack.http.CustomerService;
import jetpack.zmkj.com.jetpack.http.MyObserver;

public class UserModel extends BaseModel implements IUserModel {


    @HttpServiceAnnotation
    CustomerService customerService;



    @Override
    public void login(String username, String password, final LoginListener loginListener) {

        try {
            Thread.sleep(1000);
            User user = new User("li", "jianjun");
            loginListener.onSuccess(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mRxManager.add(customerService.login(username, password)
                .compose(RxSchedulerHelper.<User>io_main())
                .subscribe(new MyObserver<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(User user) {
                        loginListener.onSuccess(user);
                    }
                }));
    }


    public void getUserList() {
        int[] ids = new int[]{1, 2};
        CustomApplication.getInstance().getAppDatabase().userDao().loadAllByIds(ids);
    }

}
