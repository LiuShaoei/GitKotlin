package lzw.com.myapplication.bean

/**
 * Created by Administrator on 2018/9/14 0014.
 */

data class SweepLoginSuccessBean<T>(
    val code: Int,
    val msg: String,
    val data: DataSuccess
) : BaseBean()

data class DataSuccess(
    val id: Int,
    val userName: String,
    val password: String,
    val salt: String,
    val phone: String,
    val userType: String,
    val openId: String,
    val recordTime: Any,
    val lastLoginTime: Any,
    val lastLoginCity: Any,
    val recordAddr: Any
)