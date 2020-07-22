package com.nirvana.ylmc.httplib.myOkhttp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2016/12/31.
 */

public class RxManager {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();// 管理订阅者

    public void add(Disposable disposable) {
        compositeDisposable.add(disposable);
    }


    public void clear() {
        compositeDisposable.clear();// 取消订阅
    }
}
