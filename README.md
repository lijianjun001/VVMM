# VVMM
这个demo是VVMM的典型列子
demo中使用了myhttp
myhttp的使用
在gradel中添加
api 'com.zmkj:myhttp:1.0.0'
myhttp依赖第三方的库，所以在gradel中还需要添加
    ext.rxandroid_version = '2.3.0'
    api "com.squareup.retrofit2:retrofit:$rxandroid_version"
    api "com.squareup.retrofit2:converter-gson:$rxandroid_version"
    api "com.squareup.retrofit2:adapter-rxjava:$rxandroid_version"
    api 'io.reactivex:rxjava:1.3.0'
    api 'io.reactivex:rxandroid:1.2.1'
    
    然后添加创建Retrofit的类
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

在application中初始化
 HttpServiceFactory.getInstance().init(RetrofitCreator.createRetrofit());
 
 创建请求的service
 public interface CustomerService
{

     @POST("user/login")
     Observable<UserEntity> login(@Field("username") String username, @Field("password")String password);
}

在调用的类中添加如下代码

    @HttpServiceAnnotation
    private CustomerService customerService;
     HttpServiceDiscover.register(this);
     
     然后就可以调用service的方法了
     


