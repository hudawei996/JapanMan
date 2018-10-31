package com.fungo.japan.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fungo.baselib.base.basic.BaseFragment

/**
 * @author Pinger
 * @since 2018/10/31 21:27
 */
class BaseFragmentPageAdapter : FragmentPagerAdapter {

    private var mFragments = arrayListOf<BaseFragment>()
    private var mTitles = arrayListOf<String>()

    constructor(manager: FragmentManager) : super(manager)

    constructor(manager: FragmentManager, fragments: ArrayList<BaseFragment>) : super(manager) {
        this.mFragments = fragments
    }

    constructor(manager: FragmentManager, fragments: Array<BaseFragment>) : super(manager) {
        this.mFragments.addAll(fragments.toList())
    }

    constructor(manager: FragmentManager, fragments: ArrayList<BaseFragment>, titles: ArrayList<String>) : super(manager) {
        this.mFragments = fragments
        this.mTitles = titles
    }

    constructor(manager: FragmentManager, fragments: Array<BaseFragment>, titles: Array<String>) : super(manager) {
        this.mFragments.addAll(fragments.toList())
        this.mTitles.addAll(titles.toList())
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return if (mTitles.isNotEmpty()) {
            mTitles[position]
        } else {
            super.getPageTitle(position)
        }
    }

    /**
     * 更新数据
     */
    fun setData(fragments: ArrayList<BaseFragment>, titles: ArrayList<String>) {
        mFragments = fragments
        mTitles = titles
        notifyDataSetChanged()
    }


}