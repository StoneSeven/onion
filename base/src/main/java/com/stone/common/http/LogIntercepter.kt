package com.stone.common.http

import com.stone.common.util.LogUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.text.SimpleDateFormat
import java.util.*

/**
 *   created by stone
 *   on 2020/7/8
 */
class LogIntercepter : Interceptor {

    private val tag = "LogIntercepter:"
    private val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        LogUtil.i(tag+format.format(Date())
                + " Request " + "\nmethod:" + request.method() + "\nurl:" + request.url() + "\nbody:" + request.body())
        val response = chain.proceed(request)
        LogUtil.i(tag+format.format(Date())
                + " Response " + "\nsuccessful:" + response.isSuccessful + "\nbody:" + response.peekBody(1024)?.string())
        return response
    }
}