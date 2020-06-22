package jetpack.zmkj.com.jetpack.http;


import com.nirvana.ylmc.httplib.myOkhttp.ResultModel;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface CustomerService {

    @POST("PC1307")
    @FormUrlEncoded
    Observable<ResultModel<CreateOrderModel>> createOrder(@Field("buyingDetail") String buyingDetailModel, @Field("addressId") String addressId,
                                                          @Field("invoiceId") String invoiceId, @Field("teaCouponId") String teaCouponId,
                                                          @Field("type") String type, @Field("uid") String uid, @Field("sid") String sid);

    @POST("PC1302")
    @FormUrlEncoded
    Observable<ResultModel<BuyIngDetailVoModel>> preCreateOrder(@Field("productId") String productId, @Field("number") int number, @Field("uid") String uid, @Field("sid") String sid);

    @POST("PC0301")
    @FormUrlEncoded
    Observable<ResultModel<HomeDataModel>> getGoods(@Field("uid") String uid, @Field("sid") String sid);

    @POST("PC0402/")
    @FormUrlEncoded
    Observable<ResultModel<GoodsDetail>> getGoodsDetail(@Field("uid") String uid, @Field("sid") String sid, @Field("goodsId") String goodsId);

    @POST("PC0102")
    @FormUrlEncoded
    Observable<String> getVCode(@Field("mobile") String mobile, @Field("type") String type);

    @POST("PC0106")
    @FormUrlEncoded
    Observable<ResultModel<UserEntity>> vCodeLogin(@Field("mobile") String mobile, @Field("code") String code);


    @POST("PC0105")
    @FormUrlEncoded
    Observable<ResultModel<LoginModel>> login(@Field("mobile") String mobile, @Field("password") String password);

    @POST("PC0901")
    @FormUrlEncoded
    Observable<ResultModel<AddressListModel>> getAddress(@Field("uid") String uid, @Field("sid") String sid);

    @POST("PC1103")
    @FormUrlEncoded
    Observable<ResultModel<CouponModel>> getCouponList(@Field("goods") String goods, @Field("uid") String uid, @Field("sid") String sid);


}
