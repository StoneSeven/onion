package com.stone.common.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *   created by stone
 *   on 2020/7/8
 */
class RequestManager private constructor(){

    companion object{

        private fun <T> getService(baseUrl:String , service: Class<T>):T{
            var client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(LogIntercepter())
                .build()

            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(service)
        }

        fun apiService():ApiService{
            return getService(ApiService.baseUrl,ApiService::class.java)
        }
    }
}