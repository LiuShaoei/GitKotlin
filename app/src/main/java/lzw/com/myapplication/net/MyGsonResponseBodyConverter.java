package lzw.com.myapplication.net;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import lzw.com.myapplication.bean.BaseResponseBean;
import lzw.com.myapplication.bean.DataResultException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by admin on 2018/5/23.
 */

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String response = value.string();
            BaseResponseBean bean = gson.fromJson(response, BaseResponseBean.class);
            if (bean.getCode() != 0) {
                throw new DataResultException(bean.getMsg(), bean.getCode(), bean.getData());
            }

            JsonReader jsonReader = gson.newJsonReader(value.charStream());
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }

}
