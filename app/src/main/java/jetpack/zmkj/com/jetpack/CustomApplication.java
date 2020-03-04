package jetpack.zmkj.com.jetpack;

import android.app.Application;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceFactory;

import androidx.room.Room;
import jetpack.zmkj.com.jetpack.ui.main.AppDatabase;

public class CustomApplication extends Application {
    private static CustomApplication instance;
    private AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        HttpServiceFactory.getInstance().init(RetrofitCreator.createRetrofit());
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Constants.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public static CustomApplication getInstance() {
        return instance;
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }
}
