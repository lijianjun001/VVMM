package jetpack.zmkj.com.jetpack;

import android.app.Application;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceFactory;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpServiceFactory.getInstance().init(RetrofitCreator.createRetrofit());
    }
}
