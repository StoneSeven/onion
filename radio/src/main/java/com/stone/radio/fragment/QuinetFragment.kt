package com.stone.radio.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stone.common.base.BaseFragment
import com.stone.radio.R

/**
 *   created by stone
 *   on 2020/7/13
 */
class QuinetFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_silence, container, false)
    }
}