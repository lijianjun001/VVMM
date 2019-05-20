package jetpack.zmkj.com.jetpack;

import com.nirvana.ylmc.httplib.myOkhttp.converter.MyGsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

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
                .addConverterFactory(MyGsonConverterFactory.create().setVersion("001"))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private static OkHttpClient configClient() {
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return hostname.matches("\\S*emubao.com");
            }
        };
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().hostnameVerifier(hv).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .header("Authorization", AccountManager.getInstance().getToken())
                        .header("Content-Type", "application/json")
                        .header("Platform", "01").build();
                return chain.proceed(request);
            }
        }).connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();
        return okHttpClient;
    }
}
