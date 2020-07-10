package com.stone.base.http

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 *   created by stone
 *   on 2020/7/8
 */
interface ApiService {

    companion object {
        const val baseUrl = "http://baobab.kaiyanapp.com/"
    }

    @GET("api/v5/index/tab/discovery")
    fun getTabDiscovery(): Call<ResponseBody>
}