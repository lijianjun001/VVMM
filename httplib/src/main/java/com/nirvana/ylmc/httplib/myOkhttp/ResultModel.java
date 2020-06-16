package com.nirvana.ylmc.httplib.myOkhttp;

public class ResultModel<T> {
    private T datas;
    private String returnCode;
    private String returnMsg;
    private int succeed;

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public int getSucceed() {
        return succeed;
    }

    public void setSucceed(int succeed) {
        this.succeed = succeed;
    }
}
