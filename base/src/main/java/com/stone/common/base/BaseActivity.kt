package com.stone.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 *   created by stone
 *   on 2020/7/13
 */
open class BaseActivity : AppCompatActivity() , LifecycleOwner{

    class MyObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun connectListener() {

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun disconnectListener() {

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyObserver())
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