package jetpack.zmkj.com.jetpack.http;


import jetpack.zmkj.com.jetpack.ui.main.User;
import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Observable;

public interface CustomerService
{

     @POST("user/login")
     Observable<User> login(@Field("username") String username, @Field("password")String password);
}
