package com.stone.onion.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.stone.common.base.BaseActivity
import com.stone.common.util.StatusUtil
import com.stone.onion.R
import com.stone.radio.fragment.MechineFragment
import com.stone.radio.fragment.QuinetFragment
import com.stone.radio.fragment.UniverseFragment
import com.stone.radio.fragment.SilenceFragment
import kotlinx.android.synthetic.main.activity_main.*

class PodcastFragment : BaseActivity() {

    private lateinit var mTitle:ArrayList<String>
    private lateinit var mFrags:ArrayList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun initView() {
        StatusUtil.setLightStatusBar(this,true)
        mTitle = arrayListOf()
        var titleList = resources.getStringArray(R.array.radio_title)
        for (title in titleList){
            mTitle.add(title)
            radioTab.addTab(radioTab.newTab().setText(title));
        }
    }

    override fun initData(){

        mFrags = arrayListOf()

        mFrags.add(SilenceFragment())
        mFrags.add(UniverseFragment())
        mFrags.add(MechineFragment())
        mFrags.add(QuinetFragment())

        radioVp.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                return mFrags[position]
            }

            override fun getCount(): Int {
                return mFrags.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return mTitle[position]
            }
        }

        radioVp.offscreenPageLimit = mFrags.size

        radioTab.setupWithViewPager(radioVp)
    }

}