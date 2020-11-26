package jetpack.zmkj.com.jetpack;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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

public class RetrofitCreator2 {

    public static Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.APP_URL_CLIENT_IP_PORT2)
                .client(configClient())
                .addConverterFactory(MyGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
                cookies.add(new Cookie.Builder().name("lessonid").value("15413").domain("www.bjjnts.cn").build());
                cookies.add(new Cookie.Builder().name("GUIDE_MAP").value("1606267086").domain("www.bjjnts.cn").build());
                cookies.add(new Cookie.Builder().name("Hm_lvt_83efb6da7f0d1882680d3ee8ad0d78f0").value("1606203188,1606267094").domain("www.bjjnts.cn").build());
                cookies.add(new Cookie.Builder().name("PHPSESSID").value("5cbdlppqk689cls9lhqtj8d9ns").domain("www.bjjnts.cn").build());
                cookies.add(new Cookie.Builder().name("acw_tc").value("2760828316063673169185347ea59bb3f2e24167b7fe1fbd41efd37515475e").domain("www.bjjnts.cn").build());
                cookies.add(new Cookie.Builder().name("Hm_lpvt_83efb6da7f0d1882680d3ee8ad0d78f0").value("1606367318").domain("www.bjjnts.cn").build());

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
                        .addHeader("origin", "www.bjjnts.cn")
                        .build();
                return chain.proceed(request);
            }
        }).connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();
        return okHttpClient;
    }
}
