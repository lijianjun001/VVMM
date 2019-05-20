package com.nirvana.ylmc.httplib.myOkhttp;

public class ResultModel<D> {
    private int code;//0或者10086成功其他失败
    private String message;//错误信息
    private D data;//成功返回的数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

}
