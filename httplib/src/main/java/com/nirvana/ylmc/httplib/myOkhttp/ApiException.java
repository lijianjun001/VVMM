package com.nirvana.ylmc.httplib.myOkhttp;

/**
 * Created by Administrator on 2017/12/6.
 */

public class ApiException extends RuntimeException {
    private String errorCode;

    public ApiException(String code, String msg) {
        super(msg);
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

}

