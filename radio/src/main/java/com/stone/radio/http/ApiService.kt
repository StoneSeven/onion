package com.stone.radio.http

import com.stone.radio.story.HttpResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 *   created by stone
 *   on 2020/7/8
 */
interface ApiService {

    companion object {
        const val baseUrl = "https://api.imjad.cn/cloudmusic/"
    }

    // story fm
    @GET("?type=djradio&id=350038649&limit=20")
    fun getStoryList(): Call<HttpResponse>
}