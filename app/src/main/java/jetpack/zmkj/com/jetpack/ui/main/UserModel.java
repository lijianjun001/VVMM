package jetpack.zmkj.com.jetpack.ui.main;

import android.util.Log;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceAnnotation;
import com.nirvana.ylmc.httplib.myOkhttp.ResultModel;
import com.nirvana.ylmc.httplib.myOkhttp.RxSchedulerHelper;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import jetpack.zmkj.com.jetpack.Constants;
import jetpack.zmkj.com.jetpack.http.CustomerService;
import jetpack.zmkj.com.jetpack.http.MyObserver;
import jetpack.zmkj.com.jetpack.http.Normalgoods;
import jetpack.zmkj.com.jetpack.http.UserEntity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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


    public void getVCode(String telephone) {

//        String url = Constants.APP_URL_CLIENT_IP_PORT + "PC0102";
//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        FormBody formBody = new FormBody.Builder().add("mobile", telephone).build();
//
//        final Request request = new Request.Builder()
//                .url(url)
//                .post(formBody)
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d("", "onFailure: ");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("", "onResponse: " + response.body().string());
//            }
//        });
        customerService.getVCode(telephone, "0").compose(RxSchedulerHelper.<String>io_main()).subscribe(new MyObserver<String>() {

            @Override
            public void onNext(String s) {


                EventBus.getDefault().post(s);
            }

        });
    }

    public void getGoods(String telephone) {
        customerService.getGoods("1271249144307900417", "69b2d525297b424cb34264234ffcf5dd").compose(RxSchedulerHelper.<Normalgoods>io_main()).subscribe(new MyObserver<Normalgoods>() {

            @Override
            public void onNext(Normalgoods s) {


                EventBus.getDefault().post(s);
            }

        });
    }

}
