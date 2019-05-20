package jetpack.zmkj.com.jetpack.ui.main;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceDiscover;
import com.nirvana.ylmc.httplib.myOkhttp.RxManager;

public abstract class BaseModel implements LifecycleObserver {
    protected RxManager mRxManager;

    public BaseModel() {
        HttpServiceDiscover.register(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        mRxManager = new RxManager();
    }

    /**
     * 页面销毁是，取消所有请求
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {

        mRxManager.clear();
    }
}
