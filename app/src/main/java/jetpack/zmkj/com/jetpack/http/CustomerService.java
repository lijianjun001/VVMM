package jetpack.zmkj.com.jetpack.http;


import com.nirvana.ylmc.httplib.myOkhttp.ResultModel;

import jetpack.zmkj.com.jetpack.ui.main.User;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface CustomerService {

    @POST("/PC1307")
    Observable<User> createOrder(@Field("buyingDetail") BuyingDetailModel buyingDetailModel, @Field("addressId") String addressId,
                                 @Field("invoiceId") String invoiceId, @Field("teaCouponId") String teaCouponId,
                                 @Field("type") String type, @Field("uid") String uid, @Field("sid") String sid);

    @POST("/PC0301")
    Observable<User> getGoods(@Field("uid") String uid, @Field("sid") String sid);

    @POST("/PC0102")
    Observable<User> getVCode(@Field("mobile") String mobile, @Field("type") String type);

    @POST("/PC0106")
    @FormUrlEncoded
    Observable<ResultModel<UserEntity>> vCodeLogin(@Field("mobile") String mobile, @Field("code") String code);


    @POST("PC0105")
    @FormUrlEncoded
    Observable<ResultModel<UserEntity>> login(@Field("mobile") String mobile, @Field("password") String password);




}
