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