package jetpack.zmkj.com.jetpack.http;

import android.util.Log;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import rx.Observer;

/**
 * Created by lijianjun on 2017/9/7.
 */

public abstract class MyObserver<T> implements Observer<T> {

    public MyObserver() {

    }


    @Override
    public void onError(Throwable e) {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Log.e(params[0].toString(), e.toString());
    }

    @Override
    public void onCompleted() {

    }
}
