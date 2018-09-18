package lzw.com.myapplication.bean;

import java.io.IOException;

/**
 * Created by Administrator on 2018/9/14 0014.
 */


public class DataResultException extends IOException {

    public DataResultException(String msg, int code, String data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public DataResultException(String message, String msg, int code, String data) {
        super(message);
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public DataResultException(String message, Throwable cause, String msg, int code, String data) {
        super(message, cause);
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public DataResultException(Throwable cause, String msg, int code, String data) {
        super(cause);
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    /**
     * msg : 请求失败
     * code : 10011
     * data : QR_FLUSH
     */

    private String msg;
    private int code;
    private String data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
