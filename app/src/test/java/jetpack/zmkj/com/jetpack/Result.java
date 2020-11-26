package jetpack.zmkj.com.jetpack;

/**
 * @author lijianjun
 * @description:
 * @date :2020/11/26 2:28 PM
 */
public class Result {
    private int code;
    private String msg;
    private Data data;


    public static class Data {

        private String duration;
        private String learnDuration;
        private String url;

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLearnDuration() {
            return learnDuration;
        }

        public void setLearnDuration(String learnDuration) {
            this.learnDuration = learnDuration;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
