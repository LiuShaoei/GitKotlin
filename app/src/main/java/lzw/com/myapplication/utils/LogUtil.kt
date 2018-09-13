package lzw.com.myapplication.utils

import android.util.Log

/**
 * 日志操作工具类
 */

object LogUtil {
    //日志打印控制开关
    private val isPrint = true
    private val TAG = "code"

    /**
     * 单一信息打印
     *
     * @param message
     */
    fun i(message: String) {
        if (isPrint) {
            Log.i(TAG, message)
        }
    }

    /**
     * 多个信息打印
     *
     * @param message
     */
    @JvmStatic
    fun printAll(message: Array<String>) {
        if (isPrint) {
            val builder = StringBuilder()
            for (str in message) {
                builder.append(str + "\n")
            }
            Log.i(TAG, builder.toString())
        }
    }


}
