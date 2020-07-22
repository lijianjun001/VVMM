package jetpack.zmkj.com.jetpack.http;

import android.util.Log;

import com.nirvana.ylmc.httplib.myOkhttp.ApiException;
import com.nirvana.ylmc.httplib.myOkhttp.RxManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
        if (e instanceof ApiException) {
            if (((ApiException) e).getErrorCode().equals("")) {//重新登录

            }
        }
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d("Disposable", "Disposable");
        new RxManager().add(d);
        if (!d.isDisposed()) {
            d.dispose();
        }

    }

}
