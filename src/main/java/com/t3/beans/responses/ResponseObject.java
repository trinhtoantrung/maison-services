package com.t3.beans.responses;

/**
 * Created by TrungTrinh on 6/12/16.
 */
public class ResponseObject {
    Integer code;
    String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
