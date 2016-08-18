package com.mljr.demo.bean.exp;

/**
 * Created by ASUS on 2016/8/18.
 */
public class AlertException extends RuntimeException {

    public AlertException() {
        super();
    }

    public AlertException(String message) {
        super(message);
    }

    public AlertException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlertException(Throwable cause) {
        super(cause);
    }
}
