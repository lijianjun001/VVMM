package com.nirvana.ylmc.httplib.myOkhttp.converter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.nirvana.ylmc.httplib.myOkhttp.ApiException;
import com.nirvana.ylmc.httplib.myOkhttp.ResultModel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2017/12/6.
 */

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Gson mGson;
    private final TypeAdapter<T> adapter;
    private Type type;

    public MyGsonResponseBodyConverter(Type type, Gson gson, TypeAdapter<T> adapter) {
        this.type = type;
        mGson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        if (type instanceof ParameterizedType) {
            Log.d("MyGsonResponse" + ((ParameterizedType) type).getActualTypeArguments()[0].toString(), response);
        } else {
            Log.d("MyGsonResponse" + type.toString(), response);
        }
        ResultModel<String> re = mGson.fromJson(response, ResultModel.class);
        //响应码中负数的情况，一律抛出ApiException异常。
        //这样，我们就成功的将该异常交给Observer的onError()去处理了。
        if (re.getSucceed() != 0) {
            value.close();
            throw new ApiException(re.getReturnCode(), re.getReturnMsg());
        }
        MediaType mediaType = value.contentType();
        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());
        InputStreamReader reader = new InputStreamReader(bis, charset);
        try {
            return adapter.fromJson(reader);//将返回值转换为java对象
        } finally {
            value.close();
        }
    }

}

