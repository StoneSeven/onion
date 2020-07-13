package com.stone.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *   created by stone
 *   on 2020/7/13
 */
open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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