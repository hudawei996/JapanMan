package com.fungo.japan.ui.main

import androidx.viewpager.widget.ViewPager
import com.fungo.baselib.base.basic.BaseActivity
import com.fungo.baselib.base.basic.BaseFragment
import com.fungo.japan.R
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 第一个Activity，主要用来分发页面
 * 暂时用来做主页，后面会分成多个Fragment
 */
class MainActivity(override val layoutResID: Int = R.layout.activity_main) : BaseActivity() {


    override fun initView() {

        val fragments = arrayListOf<BaseFragment>()
        fragments.add(StudyFragment())
//        fragments.add(FindFragment())
//        fragments.add(SourceFragment())
//        fragments.add(UserFragment())

        viewPager.adapter = BaseFragmentPageAdapter(supportFragmentManager, fragments)

        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_study -> viewPager.setCurrentItem(0,false)
//                R.id.bottom_find -> viewPager.currentItem = 1
//                R.id.bottom_source -> viewPager.currentItem = 2
//                R.id.bottom_user -> viewPager.currentItem = 3
            }
            return@setOnNavigationItemSelectedListener true
        }

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                navigationView.menu.getItem(position).isChecked = true
            }
        })

    }
}
