package jetpack.zmkj.com.jetpack.ui.main;

import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceDiscover;
import com.nirvana.ylmc.httplib.myOkhttp.RxManager;

public abstract class BaseModel {
    protected RxManager mRxManager;

    public BaseModel() {
        HttpServiceDiscover.register(this);
        mRxManager = new RxManager();
    }

    public void onClear() {
        mRxManager.clear();
    }
}
