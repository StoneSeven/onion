package com.stone.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 *   created by stone
 *   on 2020/7/23
 */
open class BaseViewModel : ViewModel() {

    private fun sendHttpRequest(request: suspend CoroutineScope.() -> Unit){
        viewModelScope.launch { request() }
    }

    fun loadData(request: suspend CoroutineScope.() -> Unit,
                 error: suspend CoroutineScope.(Throwable) -> Unit = {},
                 result: suspend CoroutineScope.() -> Unit = {}){
        sendHttpRequest {
            try {
                request()
            }catch (e:Exception){
                error(e)
            }finally {
                result()
            }
        }
    }
}