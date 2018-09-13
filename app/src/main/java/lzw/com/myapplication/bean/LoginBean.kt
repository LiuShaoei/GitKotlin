package lzw.com.myapplication.bean


data class LoginBean<T>(
    val code: String,
    val msg: String,
    val data: Data
)

data class Data(
    val access_token: String,
    val token_type: String,
    val expires_in: String
)