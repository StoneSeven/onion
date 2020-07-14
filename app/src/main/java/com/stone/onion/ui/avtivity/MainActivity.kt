package com.stone.onion.ui.avtivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.stone.common.base.BaseActivity
import com.stone.onion.R
import com.stone.onion.ui.fragment.FourFragment
import com.stone.onion.ui.fragment.PodcastFragment
import com.stone.onion.ui.fragment.ThreeFragment
import com.stone.onion.ui.fragment.TwoFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity() {


    //Fragment 栈管理
    private val mStack = Stack<Fragment>()
    private val mPodcastFragment by lazy { PodcastFragment() }
    private val mTwoFragment by lazy { TwoFragment() }
    private val mThreeFragment by lazy { ThreeFragment() }
    private val mFourFragment by lazy { FourFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        changeFragment(0)
    }

    override fun initData(){

        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContaier,mPodcastFragment)
        manager.add(R.id.mContaier,mTwoFragment)
        manager.add(R.id.mContaier,mThreeFragment)
        manager.add(R.id.mContaier,mFourFragment)
        manager.commit()

        mStack.add(mPodcastFragment)
        mStack.add(mTwoFragment)
        mStack.add(mThreeFragment)
        mStack.add(mFourFragment)


        bnvMenu.setOnNavigationItemSelectedListener { menu ->
            when(menu.itemId){
                R.id.item_bottom_1 -> {
                    changeFragment(0)
                }
                R.id.item_bottom_2 -> {
                    changeFragment(1)
                }
                R.id.item_bottom_3 -> {
                    changeFragment(2)
                }
                R.id.item_bottom_4 -> {
                    changeFragment(3)
                }
            }
            true
        }
    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }

}