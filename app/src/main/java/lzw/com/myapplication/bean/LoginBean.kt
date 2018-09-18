package lzw.com.myapplication.bean


data class LoginBean<T>(
        val code: Int,
        val msg: String,
        val data: LoginData<T>
): BaseBean()

data class LoginData<T>(
    val access_token: String,
    val flush_time: Long,
    val user: LoginUser
)
data class LoginUser(
        var id : Int,
        var userName: String ,
        var password: String ,
        var salt: String ,
        var phone :String ,
        var userType: String ,
        var openId: String
)
//{"code":0,"msg":"请求成功","data":
//    {"access_token":"Q2czS**","flush_time":2591999999,"user":
//        {"id":1,
//            "userName":"admin",
//            "password":"BC9B5718AFDFFE85FB13555347969FF5",
//            "salt":"abcd",
//            "phone":"123123",
//            "userType":"1",
//            "openId":"113123",
//            "recordTime":null,
//            "lastLoginTime":null,
//            "lastLoginCity":null,
//            "recordAddr":null}}}null