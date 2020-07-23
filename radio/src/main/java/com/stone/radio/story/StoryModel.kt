package com.stone.radio.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stone.common.base.BaseData
import com.stone.common.base.BaseViewModel
import com.stone.common.util.LogUtil
import com.stone.radio.http.RequestRadioManager
import kotlinx.coroutines.*

/**
 *   created by stone
 *   on 2020/7/17
 */
class StoryModel : BaseViewModel() {

    private val storyData: MutableLiveData<BaseData<HttpResponse>> by lazy {
        loadStoryData()
        MutableLiveData<BaseData<HttpResponse>>()
    }

    fun getStoryData(): LiveData<BaseData<HttpResponse>> {
        return storyData
    }

    private fun loadStoryData(){
        viewModelScope.launch(Dispatchers.Main) {
            try{
                val response = withContext(Dispatchers.IO) {
                    RequestRadioManager.apiService().getStoryList().execute()
                }
                if(response!!.isSuccessful){
                    LogUtil.i("response success " + response.body()?.code)
                    storyData.value = BaseData(response.body()!!,200,"")
                }else{
                    LogUtil.i("response fail")
                }
            }catch(e: Throwable){
                LogUtil.i("response error " + e.message)
            }
        }
    }
}