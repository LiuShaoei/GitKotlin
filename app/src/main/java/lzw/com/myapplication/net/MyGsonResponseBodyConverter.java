package lzw.com.myapplication.net;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.lang.reflect.Type;

import lzw.com.myapplication.bean.BaseResponseBean;
import lzw.com.myapplication.bean.DataResultException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by admin on 2018/5/23.
 */

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private Type type;

    MyGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String response = value.string();
            BaseResponseBean bean = gson.fromJson(response, BaseResponseBean.class);
            if (bean.getCode() != 0) {
                throw new DataResultException(bean.getMsg(), bean.getCode(), (String)bean.getData());
            }
            return  gson.fromJson(response, type);
        } finally {
            value.close();
        }
    }

}
