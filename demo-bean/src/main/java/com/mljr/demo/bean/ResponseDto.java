package com.mljr.demo.bean;


import com.mljr.demo.bean.constant.Code;

/**
 * Created by ASUS on 2016/7/26.
 */
public class ResponseDto<T> {

    int     code = Code.S_200;
    T       data;
    String  msg;
    long    timestamp = System.currentTimeMillis();

    public static <T> ResponseDto rsOK(T data){
        ResponseDto dto = new ResponseDto();
        dto.data = data;
        return dto;
    }

    public static <T> ResponseDto rsAlert(String msg){
        ResponseDto dto = new ResponseDto();
        dto.msg = msg;
        return dto;
    }

    public static ResponseDto rsFail(int code, String msg){
        ResponseDto dto = new ResponseDto();
        dto.code = code;
        dto.msg = msg;
        return dto;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
