package lzw.com.myapplication.net

import io.reactivex.Observable
import lzw.com.myapplication.bean.Data
import lzw.com.myapplication.bean.LoginBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    /**
     * 登陆
     */
    @FormUrlEncoded
    @POST("/v1/auth/token")
    fun login(@Field("username")username :String ,@Field("password")password :String ) : Observable<LoginBean<Data>>

}