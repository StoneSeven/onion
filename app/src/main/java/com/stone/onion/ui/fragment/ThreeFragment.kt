package com.stone.onion.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.stone.common.base.BaseFragment
import com.stone.common.util.StatusUtil
import com.stone.onion.R
import com.stone.radio.fragment.MechineFragment
import com.stone.radio.fragment.QuinetFragment
import com.stone.radio.fragment.UniverseFragment
import com.stone.radio.fragment.SilenceFragment
import kotlinx.android.synthetic.main.activity_main.*

class ThreeFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_podcast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun initView() {

    }

    override fun initData(){

    }

}