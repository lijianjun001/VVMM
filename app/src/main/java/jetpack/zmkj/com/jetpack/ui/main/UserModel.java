package jetpack.zmkj.com.jetpack.ui.main;

import android.util.Log;

import com.google.gson.Gson;
import com.nirvana.ylmc.httplib.myOkhttp.HttpServiceAnnotation;
import com.nirvana.ylmc.httplib.myOkhttp.ResultModel;
import com.nirvana.ylmc.httplib.myOkhttp.RxSchedulerHelper;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import jetpack.zmkj.com.jetpack.http.AddressListModel;
import jetpack.zmkj.com.jetpack.http.AddressModel;
import jetpack.zmkj.com.jetpack.http.BuyIngDetailVoModel;
import jetpack.zmkj.com.jetpack.http.BuyingDetailModel;
import jetpack.zmkj.com.jetpack.http.CouponEntity;
import jetpack.zmkj.com.jetpack.http.CouponModel;
import jetpack.zmkj.com.jetpack.http.CreateOrderModel;
import jetpack.zmkj.com.jetpack.http.CustomerService;
import jetpack.zmkj.com.jetpack.http.GoodsDetail;
import jetpack.zmkj.com.jetpack.http.HomeDataModel;
import jetpack.zmkj.com.jetpack.http.LoginModel;
import jetpack.zmkj.com.jetpack.http.MyObserver;
import jetpack.zmkj.com.jetpack.http.OrderGoodModel;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class UserModel extends BaseModel {


    @HttpServiceAnnotation
    private CustomerService customerService;


    public static HashMap<String, CreateOrderModel2> createOrderModel2HashMap = new HashMap<>();


    public void login(String username, String password) {

        mRxManager.add(customerService.login(username, password)
                .compose(RxSchedulerHelper.<ResultModel<LoginModel>>io_main())
                .subscribe(new MyObserver<ResultModel<LoginModel>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("LoginModel", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("LoginModel", e.getMessage());
                    }

                    @Override
                    public void onNext(ResultModel<LoginModel> loginModelResultModel) {

                        CreateOrderModel2 createOrderModel2 = new CreateOrderModel2();
                        String uid = loginModelResultModel.getDatas().getUser().getUid();
                        createOrderModel2.setUid(uid);
                        createOrderModel2.setSid(loginModelResultModel.getDatas().getSid());
                        createOrderModel2HashMap.put(uid, createOrderModel2);
                        preCreateOrder(loginModelResultModel.getDatas());
                        EventBus.getDefault().post(loginModelResultModel.getDatas());
                    }
                }));


    }


    public void getVCode(String telephone) {

//        String url = Constants.APP_URL_CLIENT_IP_PORT + "PC0102";
//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        FormBody formBody = new FormBody.Builder().add("mobile", telephone).build();
//
//        final Request request = new Request.Builder()
//                .url(url)
//                .post(formBody)
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d("", "onFailure: ");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("", "onResponse: " + response.body().string());
//            }
//        });
        customerService.getVCode(telephone, "0").compose(RxSchedulerHelper.<String>io_main()).subscribe(new MyObserver<String>() {

            @Override
            public void onNext(String s) {


                EventBus.getDefault().post(s);
            }

        });
    }

    public void getGoods(String uid, String sid) {
        customerService.getGoods(uid, sid).compose(RxSchedulerHelper.<ResultModel<HomeDataModel>>io_main()).subscribe(new MyObserver<ResultModel<HomeDataModel>>() {

            @Override
            public void onNext(ResultModel<HomeDataModel> homeDataModel) {

                EventBus.getDefault().post(homeDataModel.getDatas());
            }

        });
    }

    public void getGoodsDetail(String uid, String sid, String goodsId) {
        customerService.getGoodsDetail(uid, sid, goodsId).compose(RxSchedulerHelper.<ResultModel<GoodsDetail>>io_main()).subscribe(new MyObserver<ResultModel<GoodsDetail>>() {

            @Override
            public void onNext(ResultModel<GoodsDetail> goodsDetail) {

                EventBus.getDefault().post(goodsDetail.getDatas());
            }

        });
    }


    public void getAddress(String uid, String sid) {


        customerService.getAddress(uid, sid).compose(RxSchedulerHelper.<ResultModel<AddressListModel>>io_main()).subscribe(new MyObserver<ResultModel<AddressListModel>>() {

            @Override
            public void onNext(ResultModel<AddressListModel> goodsDetail) {

                EventBus.getDefault().post(goodsDetail.getDatas());
            }

        });
    }


    public void preCreateOrder(String productId, int number, String uid, String sid) {
        customerService.preCreateOrder(productId, number, uid, sid).compose(RxSchedulerHelper.<ResultModel<BuyIngDetailVoModel>>io_main()).subscribe(new MyObserver<ResultModel<BuyIngDetailVoModel>>() {
            @Override
            public void onNext(ResultModel<BuyIngDetailVoModel> buyIngDetailVoModelResultModel) {

                EventBus.getDefault().post(buyIngDetailVoModelResultModel.getDatas());
            }
        });
    }

    public void getCouponList(List<OrderGoodModel> goods, String uid, String sid) {


        customerService.getCouponList(new Gson().toJson(goods), uid, sid).compose(RxSchedulerHelper.<ResultModel<CouponModel>>io_main()).subscribe(new MyObserver<ResultModel<CouponModel>>() {
            @Override
            public void onNext(ResultModel<CouponModel> listResultModel) {
                EventBus.getDefault().post(listResultModel.getDatas());
            }
        });
    }

    /**
     * @param addressModel
     * @param goods
     * @param addressId
     * @param invoiceId    发票
     * @param uid
     * @param sid
     */
    public void createOrder(AddressModel addressModel, List<OrderGoodModel> goods, float freight, double totalFee, String addressId, String invoiceId, String teaCouponId, String type, String uid, String sid) {

        BuyingDetailModel buyingDetailModel = new BuyingDetailModel();
        buyingDetailModel.setAddresses(addressModel);
        buyingDetailModel.setFreight(freight);//运费
        buyingDetailModel.setFreightContent("");
        buyingDetailModel.setGoods(goods);
        buyingDetailModel.setInvoice(false);
        buyingDetailModel.setRemark("");//备注信息
        buyingDetailModel.setTotalFee(totalFee);

        customerService.createOrder(new Gson().toJson(buyingDetailModel), addressId, invoiceId, teaCouponId, type, uid, sid).compose(RxSchedulerHelper.<ResultModel<CreateOrderModel>>io_main()).subscribe(new MyObserver<ResultModel<CreateOrderModel>>() {

            @Override
            public void onNext(ResultModel<CreateOrderModel> booleanResultModel) {


            }

        });
    }


    public void preCreateOrder(LoginModel loginModel) {


        final String uid = loginModel.getUser().getUid();
        final String sid = loginModel.getSid();
        Observable goodsOb = customerService.getGoods(uid, sid);

        final CreateOrderModel2 createOrderModel2 = createOrderModel2HashMap.get(uid);

        customerService.getAddress(uid, sid).compose(RxSchedulerHelper.<ResultModel<AddressListModel>>io_main()).subscribe(new MyObserver<ResultModel<AddressListModel>>() {

            @Override
            public void onNext(ResultModel<AddressListModel> addressListModelResultModel) {

                createOrderModel2.setAddressModel(addressListModelResultModel.getDatas().getAddresses().get(0));
                createOrderModel2.setAddressId(addressListModelResultModel.getDatas().getAddresses().get(0).getId());
            }

        });

        goodsOb.flatMap(new Func1<ResultModel<HomeDataModel>, Observable<ResultModel<GoodsDetail>>>() {

            @Override
            public Observable<ResultModel<GoodsDetail>> call(ResultModel<HomeDataModel> homeDataModelResultModel) {
                String goodsId = homeDataModelResultModel.getDatas().getHomeData().getBanner().get(0).getBizId();
                return customerService.getGoodsDetail(uid, sid, goodsId);
            }
        }).subscribeOn(Schedulers.io()).flatMap(new Func1<ResultModel<GoodsDetail>, Observable<ResultModel<BuyIngDetailVoModel>>>() {

            @Override
            public Observable<ResultModel<BuyIngDetailVoModel>> call(ResultModel<GoodsDetail> goodsDetailResultModel) {
                GoodsDetail goodsDetail = goodsDetailResultModel.getDatas();
                String productId = goodsDetail.getGoodsDetail().getSpec().get(0).getRefPid();

                return customerService.preCreateOrder(productId, 1, uid, sid);
            }
        }).flatMap(new Func1<ResultModel<BuyIngDetailVoModel>, Observable<ResultModel<CouponModel>>>() {

            @Override
            public Observable<ResultModel<CouponModel>> call(ResultModel<BuyIngDetailVoModel> buyIngDetailVoModelResultModel) {
                BuyIngDetailVoModel buyIngDetailVoModel = buyIngDetailVoModelResultModel.getDatas();
                List<OrderGoodModel> orderGoodModels = buyIngDetailVoModel.getBuyIngDetailVo().getGoods();

                createOrderModel2.setFreight(buyIngDetailVoModel.getBuyIngDetailVo().getFreight());
                createOrderModel2.setGoods(orderGoodModels);
                createOrderModel2.setTotalFee(buyIngDetailVoModel.getBuyIngDetailVo().getTotalFee());
                createOrderModel2.setType("0");

                return customerService.getCouponList(new Gson().toJson(orderGoodModels), uid, sid);
            }
        }).subscribe(new MyObserver<ResultModel<CouponModel>>() {
            @Override
            public void onNext(ResultModel<CouponModel> couponModelResultModel) {
                String couponId = "";
                List<CouponEntity> couponEntities = couponModelResultModel.getDatas().getCouponList();
                if (couponEntities != null && couponEntities.size() > 0) {
                    couponId = couponEntities.get(0).getId();
                }
                createOrderModel2.setTeaCouponId(couponId);
            }

        });

    }


}
