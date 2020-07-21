package com.stone.radio.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stone.common.base.BaseData
import com.stone.common.util.LogUtil
import com.stone.radio.http.RequestRadioManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 *   created by stone
 *   on 2020/7/17
 */
class StoryModel : ViewModel() {


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
                val deferred = async(Dispatchers.IO) {
                    RequestRadioManager.apiService().getStoryList().execute()
                }
                val response = deferred.await()
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