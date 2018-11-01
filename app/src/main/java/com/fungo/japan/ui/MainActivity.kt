package com.fungo.japan.ui

import com.fungo.baselib.base.basic.BaseActivity
import com.fungo.baselib.base.basic.BaseFragment
import com.fungo.japan.R
import com.fungo.japan.ui.find.FindFragment
import com.fungo.japan.ui.main.StudyFragment
import com.fungo.japan.ui.source.SourceFragment
import com.fungo.japan.ui.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 第一个Activity，主要用来分发页面
 * 暂时用来做主页，后面会分成多个Fragment
 */
class MainActivity(override val layoutResID: Int = R.layout.activity_main) : BaseActivity() {


    override fun initView() {
        val fragments = arrayListOf<BaseFragment>()
        fragments.add(StudyFragment())
        fragments.add(FindFragment())
        fragments.add(SourceFragment())
        fragments.add(UserFragment())

        loadMultipleRootFragment(
                R.id.mainContainer,
                0,
                fragments[0],
                fragments[1],
                fragments[2],
                fragments[3])

        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_study -> showHideFragment(fragments[0])
                R.id.bottom_find -> showHideFragment(fragments[1])
                R.id.bottom_source -> showHideFragment(fragments[2])
                R.id.bottom_user -> showHideFragment(fragments[3])
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
