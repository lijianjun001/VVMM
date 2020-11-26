package jetpack.zmkj.com.jetpack;


import org.json.JSONObject;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private void assertEquals(int i, int i1) {

    }

    @Test
    public void bj() throws Exception {
        //第二课
        int les = 958;
        //第四课
        //int les = 974;
        for (int lessonid = 15413; lessonid < 15491; lessonid++) {
            Map<String, String> headers = new HashMap<>(1);
            headers.put("Cookie", "lessonid=" + (lessonid - 1) + "; GUIDE_MAP:=1606301280; Hm_lvt_83efb6da7f0d1882680d3ee8ad0d78f0=1606301281; PHPSESSID=6gt3o3l981fu3ldmb8fii87chm; acw_tc=2760829816063601659433246e7a66d7c3e9b02c7908f59866008e3672308d; Hm_lpvt_83efb6da7f0d1882680d3ee8ad0d78f0=1606361640");
            String data1 = post("https://www.bjjnts.cn/lessonStudy/" + les + "/" + lessonid, headers);

            //System.out.println(post);

            JSONObject jsonObject = new JSONObject(data1);
            JSONObject data = jsonObject.getJSONObject("data");
            String duration = data.getString("duration");
            Map<String, String> headers2 = new HashMap<>(1);
            headers2.put("Cookie", "GUIDE_MAP:=1606301280; Hm_lvt_83efb6da7f0d1882680d3ee8ad0d78f0=1606301281; PHPSESSID=6gt3o3l981fu3ldmb8fii87chm; acw_tc=2760827816063677322431629ef61b0870e2ca70bae2c3bb24745df0960d4a; Hm_lpvt_83efb6da7f0d1882680d3ee8ad0d78f0=1606368627");
            String post2 = post("https://www.bjjnts.cn/addstudentTaskVer2/" + les + "/" + lessonid + "?learnTime=" + duration + "&push_event=ended", headers2);
            System.out.println(post2);
            Thread.sleep(Long.parseLong(duration));
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
        return connection.getResponseMessage();
    }
}