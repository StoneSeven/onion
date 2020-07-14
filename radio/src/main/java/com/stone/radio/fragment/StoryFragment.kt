package com.stone.radio.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stone.common.base.BaseFragment
import com.stone.common.util.LogUtil
import com.stone.radio.R
import com.stone.radio.http.RequestRadioManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *   created by stone
 *   on 2020/7/13
 */
class StoryFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun initData() {
        GlobalScope.launch(Dispatchers.IO) {
            try{
                val response = RequestRadioManager.apiService().getStoryList().execute()
                if(response.isSuccessful){
                    LogUtil.i("response success " + response.body()?.code)
                }else{
                   LogUtil.i("response fail")
                }
            }catch(e: Throwable){
                LogUtil.i("response error " + e.message)
            }
        }
    }
}