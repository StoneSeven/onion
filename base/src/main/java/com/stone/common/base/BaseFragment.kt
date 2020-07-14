package com.stone.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *   created by stone
 *   on 2020/7/13
 */
open class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected open fun init() {
        initView()
        initData()
    }

    protected open fun initView() {

    }

    protected open fun initData() {

    }
}