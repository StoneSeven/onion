package com.stone.radio.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.stone.common.base.BaseData
import com.stone.common.base.BaseFragment
import com.stone.common.util.LogUtil
import com.stone.radio.R
import com.stone.radio.http.RequestRadioManager
import com.stone.radio.story.HttpResponse
import com.stone.radio.story.Program
import com.stone.radio.story.StoryListAdapter
import com.stone.radio.story.StoryModel
import kotlinx.android.synthetic.main.fragment_story.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


/**
 *   created by stone
 *   on 2020/7/13
 */
class StoryFragment : BaseFragment() {

    private var mDataList = ArrayList<Program>(20)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun initView() {
        val layoutManage = LinearLayoutManager(activity)
        layoutManage.orientation = LinearLayoutManager.HORIZONTAL
        recycleStory.layoutManager = layoutManage
    }

    override fun initData() {
        val model = ViewModelProviders.of(this).get(StoryModel::class.java)
        model.getStoryData().observe(this, Observer<BaseData<HttpResponse>>{ response ->
            // update UI
            recycleStory.adapter = StoryListAdapter(response.mData.programs, activity!!)
        })
    }
}