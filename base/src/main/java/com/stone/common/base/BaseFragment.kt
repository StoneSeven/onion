package com.stone.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 *   created by stone
 *   on 2020/7/13
 */
open class BaseFragment : Fragment() , LifecycleOwner {

    class MyObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun connectListener() {

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun disconnectListener() {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected open fun init() {
        lifecycle.addObserver(BaseActivity.MyObserver())
        initView()
        initData()
    }

    protected open fun initView() {

    }

    protected open fun initData() {

    }
}