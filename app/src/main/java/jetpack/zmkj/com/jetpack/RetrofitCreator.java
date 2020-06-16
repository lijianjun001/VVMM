package jetpack.zmkj.com.jetpack;

import com.nirvana.ylmc.httplib.myOkhttp.converter.MyGsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class RetrofitCreator {

    public static Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.APP_URL_CLIENT_IP_PORT)
                .client(configClient())
                .addConverterFactory(MyGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

    private static CookieJar cookieJar = new CookieJar() {
        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            cookieStore.put(url.host(), cookies);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url.host());
            if (cookies == null) {
                cookies = new ArrayList<>();
                cookies.add(new Cookie.Builder().name("xn_dvid_kf_20155").value("97DA66-17349ED8-BD98-CB82-28D9-A61DBBFD9C21").domain("www.yestae.com").build());
                cookies.add(new Cookie.Builder().name("xn_sid_kf_20155").value("1592184539819288").domain("www.yestae.com").build());
                cookies.add(new Cookie.Builder().name("eks_cache_keys").value("true").domain("www.yestae.com").build());

            }
            return cookies;
        }
    };

    private static OkHttpClient configClient() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().cookieJar(cookieJar).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("accept", "application/json, text/plain, */*")
                        .addHeader("accept-encoding", "gzip, deflate, br")
                        .addHeader("accept-language", "zh-CN,zh;q=0.9")
                        .addHeader("content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                        .addHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Mobile Safari/537.36")
                        .addHeader("origin", "https://www.yestae.com")
                        .addHeader("referer", "https://www.yestae.com/login")
                        .addHeader("sec-fetch-dest", "empty")
                        .addHeader("sec-fetch-mode", "cors")
                        .addHeader("sec-fetch-site", "same-origin")
                        .build();
                return chain.proceed(request);
            }
        }).connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();
        return okHttpClient;
    }
}
