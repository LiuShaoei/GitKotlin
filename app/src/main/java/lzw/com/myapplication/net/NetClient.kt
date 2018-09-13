package lzw.com.myapplication.net

import lzw.com.myapplication.utils.SharePrefUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetClient {
    companion object {
        val time: Long = 30 * 1000
        val base_url = "http://47.106.34.246:9082/"
        private fun create(url: String): Retrofit? {
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }


        private fun getHttpClient(): OkHttpClient {
            var okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            okHttpClient.connectTimeout(time, TimeUnit.SECONDS)
                    .readTimeout(time, TimeUnit.SECONDS)
            okHttpClient.addInterceptor(HeaderInterceptor())
            okHttpClient.addInterceptor(LoggingInterceptor())
            return okHttpClient.build()
        }

        class HeaderInterceptor : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                var request: Request = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer " + SharePrefUtils("access_token", ""))
                        .build()
                return chain.proceed(request)
            }

        }

        val apiService: ApiService = create(base_url)!!.create(ApiService::class.java)
    }
}