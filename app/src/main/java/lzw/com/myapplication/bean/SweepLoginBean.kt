package lzw.com.myapplication.bean

/**
 * Created by Administrator on 2018/9/14 0014.
 */

data class SweepLoginBean<T>(

    val code: Int,
    val msg: String,
    val data: SweepData
) : BaseBean()
data class SweepData(
    val uuid: String,
    val token: String
)
