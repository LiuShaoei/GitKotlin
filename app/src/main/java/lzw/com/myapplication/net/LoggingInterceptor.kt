package lzw.com.myapplication.net

import lzw.com.myapplication.utils.LogUtil
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException

/**
 * Created by admin on 2018/1/29.
 */

class LoggingInterceptor : Interceptor {
    private val UTF8 = Charset.forName("UTF-8")

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val requestBody = request.body() as FormBody?
        var body: String? = null
        if (requestBody != null) {
            val buffer = Buffer()
            requestBody.writeTo(buffer)
            var charset: Charset? = UTF8
            val contentType = requestBody.contentType()
            if (contentType != null) {
                charset = contentType.charset(UTF8)
            }
            body = buffer.readString(charset!!)
        }

        LogUtil.i("请求：" + "\n url" + request.url() + "\n body   " + body)

        val response = chain.proceed(request)
        val responseBody = response.body()
        var rBody: String? = null
        val source = responseBody!!.source()
        source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
        val buffer = source.buffer()
        var charset: Charset? = UTF8
        val contentType = responseBody.contentType()
        if (contentType != null) {
            try {
                charset = contentType.charset(UTF8)
            } catch (e: UnsupportedCharsetException) {
                e.printStackTrace()
            }

        }
        rBody = buffer.clone().readString(charset!!)
        LogUtil.i("收到响应\n" + response.request().url() + "\n" + rBody)
        return response
    }
}
