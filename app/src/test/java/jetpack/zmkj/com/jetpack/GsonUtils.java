package jetpack.zmkj.com.jetpack;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Gson工具类
 *
 * @author lijianjun created 2015-12-29
 */
public class GsonUtils {

    /**
     * 对象转换Json字符串
     *
     * @param obj 对象实例
     * @return json字符串
     */
    public static String toJson(Object obj) {
        try {
            Gson gson = new Gson();

            return gson.toJson(obj);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Json字符串转换成对象
     *
     * @param jsonString json字符串
     * @param className  对象类名称
     * @param <T>        类泛型
     * @return 根据泛型将json字符串转换成具体类
     */
    public static <T> T fromJson(String jsonString, Class<T> className) {
        if (jsonString == null) {
            return null;
        }

        try {
            Gson gson = new Gson();
            return gson.fromJson(jsonString, className);
        } catch (Exception e) {
            Log.e("test", e.getMessage());
        }

        return null;
    }


    /**
     * json字符串转换为集合
     *
     * @param jsonString json字符串
     * @param type       反射类型
     * @param <T>        泛型
     * @return 具体类的集合列表
     */
    public static <T> ArrayList<T> fromJsonToArrayList(String jsonString, Type type) {
        if (jsonString == null || type == null) {
            return null;
        }
        try {
            Gson gson = new Gson();

            return gson.fromJson(jsonString, type);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 将Map转化为Json
     *
     * @param map
     * @return String
     */
    public static <T> String mapToJson(Map<String, T> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }


    public static void main(String[] args) {
        String json = "['李建军']";
        ArrayList<String> arrayList = fromJsonToArrayList(json, String.class);
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
