package jetpack.zmkj.com.jetpack.http;


import jetpack.zmkj.com.jetpack.ui.main.UserEntity;
import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Observable;

public interface CustomerService
{

     @POST("user/login")
     Observable<UserEntity> login(@Field("username") String username, @Field("password")String password);
}
