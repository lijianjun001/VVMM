package jetpack.zmkj.com.jetpack.http;


import com.nirvana.ylmc.httplib.myOkhttp.converter.MyGsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import jetpack.zmkj.com.jetpack.Constants;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by lijianjun on 2016/12/27.
 */

public class HttpServiceManager {
    private static HttpServiceManager serviceManager;

    private HashMap<String, Object> hashMap = new HashMap<>();


    public static HttpServiceManager getInstance() {
        if (serviceManager == null) {
            serviceManager = new HttpServiceManager();
        }
        return serviceManager;
    }

    public <T> T configRetrofit(Class<T> service) {
        if (!hashMap.containsKey(service.getClass().getName())) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.APP_URL_CLIENT_IP_PORT)
                    .client(configClient())
                    .addConverterFactory(MyGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            T t = retrofit.create(service);
            hashMap.put(service.getClass().getName(), t);
            return t;
        } else {
            return (T)hashMap.get(service.getClass().getName());
        }

    }

    private OkHttpClient configClient() {

        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return hostname.matches("\\S*emubao.com");
            }
        };
        final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().hostnameVerifier(hv).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Platform", "01").build();
                return chain.proceed(request);
            }
        }).connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS).cookieJar(new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                cookieStore.put(httpUrl.host(), list);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                List<Cookie> cookies = cookieStore.get(httpUrl.host());
                return cookies != null ? cookies : new ArrayList<Cookie>();
            }
        }).build();
        return okHttpClient;
    }

}
