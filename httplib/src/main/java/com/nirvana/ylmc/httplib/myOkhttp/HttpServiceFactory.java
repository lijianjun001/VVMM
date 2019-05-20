package com.nirvana.ylmc.httplib.myOkhttp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Retrofit;

/**
 * Created by lijianjun on 2016/12/27.
 */

public class HttpServiceFactory {
    private Retrofit retrofit;

    private static Map<String, Object> hashMap = new ConcurrentHashMap<>();

    private static volatile HttpServiceFactory serviceManager;

    public static HttpServiceFactory getInstance() {
        if (serviceManager == null) {
            synchronized (HttpServiceFactory.class) {
                if (serviceManager == null) {
                    serviceManager = new HttpServiceFactory();
                }
            }
        }
        return serviceManager;
    }


    public void init(Retrofit retrofit) {

        this.retrofit = retrofit;
    }

    public <T> T createService(Class<T> service) {
        String name = service.getName();
        if (!hashMap.containsKey(name)) {

            T t = retrofit.create(service);
            hashMap.put(name, t);
            return t;
        } else {
            return (T) hashMap.get(name);
        }
    }

}
