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
import kotlinx.android.synthetic.main.fragment_podcast.*

class PodcastFragment : BaseFragment() {

    private lateinit var mTitle:ArrayList<String>
    private lateinit var mFrags:ArrayList<Fragment>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_podcast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun initView() {
        StatusUtil.setLightStatusBar(activity!!,true)
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

        radioVp.adapter = object : FragmentPagerAdapter(activity!!.supportFragmentManager) {

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