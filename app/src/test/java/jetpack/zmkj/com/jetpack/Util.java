package jetpack.zmkj.com.jetpack;

import org.junit.Test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Util {
    @Test
    public void aa() {
        //生成一个长度为10的缓冲区
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < intBuffer.capacity(); ++i) {
            int randomNum = new Random().nextInt(20);
            intBuffer.put(randomNum);
        }
        //状态翻转
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            //读取数据
            System.out.print(intBuffer.get() + ",");
        }
        //clear方法本质上并不是删除数据
        intBuffer.clear();
        System.out.print("\n");
        System.out.println("-----------------------------");
        while (intBuffer.hasRemaining()) {
            System.out.print(intBuffer.get() + ",");
        }
    }

    @Test
    public void bj() throws Exception {
        //第二课
//        int les = 974;//962,958,970,974
//        int lesson = 16082;//12210 +7   ,15412+79,15933+25,16066+60

        List<Lesson> lessons = new ArrayList<>(4);
        lessons.add(new Lesson(962, 12210, 7));
        lessons.add(new Lesson(958, 15412, 79));
        lessons.add(new Lesson(970, 15933, 25));
        lessons.add(new Lesson(974, 16066, 60));

        String cookie = "GUIDE_MAP:=1606267086; Hm_lvt_83efb6da7f0d1882680d3ee8ad0d78f0=1606203188,1606267094; PHPSESSID=5cbdlppqk689cls9lhqtj8d9ns; acw_tc=276082a916063723062812142edc079db3b732fc397ff7b9e2f4873e640817; Hm_lpvt_83efb6da7f0d1882680d3ee8ad0d78f0=1606372349";
        for (Lesson lesson1 : lessons) {

            int start = lesson1.getStart();
            int les = lesson1.getLesson();
            int end = start + lesson1.getCount();
            for (int lessonid = start; lessonid < end; lessonid++) {
                Map<String, String> headers = new HashMap<>(1);
                headers.put("Cookie", "lessonid=" + (lessonid - 1) + "; " + cookie);
                String data1 = post("https://www.bjjnts.cn/lessonStudy/" + les + "/" + lessonid, headers);

                System.out.println(data1);


                Result result = GsonUtils.fromJson(data1, Result.class);


                String duration = result.getData().getDuration();
//            Thread.sleep(120 * 1000);
                Map<String, String> headers2 = new HashMap<>(1);
                headers2.put("Cookie", cookie);
                String post2 = post("https://www.bjjnts.cn/addstudentTaskVer2/" + les + "/" + lessonid + "?learnTime=" + duration + "&push_event=ended", headers2);
                System.out.println(post2);

            }
        }
    }

    public String post(String urlStr, Map<String, String> headers) throws Exception {
        URL url = new URL(urlStr);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("charset", "utf-8");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        int code = connection.getResponseCode();

        int successStatusCode = 200;
        if (code != successStatusCode) {
            throw new Exception("异常");

        }
        InputStream inputStream = connection.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return new String(bytes);
    }
}
