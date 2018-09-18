package lzw.com.myapplication.net

import io.reactivex.Observable
import lzw.com.myapplication.bean.*
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    /**
     * 登陆
     */
    @FormUrlEncoded
    @POST("/api/user/doLogin")
    fun login(@Field("name")username :String ,@Field("password")password :String ) : Observable<LoginBean<LoginData<LoginUser>>>

    /**
     * 扫码成功给后台回调
     */
    @FormUrlEncoded
    @POST("/api/qrScan")
    fun sweepLogin(@Field("token")token :String ,@Field("uuid") uuid :String ) : Observable<SweepLoginBean<SweepData>>

    /**
     * 扫码成功确认登陆
     */
    @FormUrlEncoded
    @POST("/api/qrLogin")
    fun sureSweepLogin(@Field("token")token :String ,@Field("uuid") uuid :String ) : Observable<SweepLoginSuccessBean<DataSuccess>>

}