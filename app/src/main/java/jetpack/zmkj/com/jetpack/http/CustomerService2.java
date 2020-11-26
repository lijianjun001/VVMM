package jetpack.zmkj.com.jetpack.http;


import com.nirvana.ylmc.httplib.myOkhttp.ResultModel2;

import io.reactivex.Observable;
import jetpack.zmkj.com.jetpack.bj.BjModel1;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CustomerService2 {

    @POST("lessonStudy/958/15412")
    @FormUrlEncoded
    Observable<ResultModel2<BjModel1>> getData();

    @POST("addstudentTaskVer2/958/15412")
    @FormUrlEncoded
    Observable<ResultModel2<String>> setData(@Field("learnTime") long learnTime, @Field("push_event") String push_event);


}
