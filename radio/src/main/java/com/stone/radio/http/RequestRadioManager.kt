package com.stone.radio.http

import com.stone.common.http.RequestManager

/**
 *   created by stone
 *   on 2020/7/8
 */
class RequestRadioManager private constructor() : RequestManager() {

    companion object{

        fun apiService(): ApiService {
            return getService(ApiService.baseUrl,ApiService::class.java)
        }
    }
}