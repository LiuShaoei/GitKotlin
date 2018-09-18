package lzw.com.myapplication.bean;

/**
 * Created by Administrator on 2018/9/14 0014.
 */

public class BaseResponseBean {

    /**
     * msg : 请求失败
     * code : 10010
     * data : ALREADY_SCAN
     */

    private String msg;
    private int code;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



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


}
