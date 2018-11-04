package com.fungo.japan.ui.main

import com.fungo.baseuilib.fragment.BaseContentFragment
import com.fungo.baseuilib.fragment.BaseFragment
import com.fungo.japan.R
import com.fungo.japan.ui.find.FindFragment
import com.fungo.japan.ui.home.HomeFragment
import com.fungo.japan.ui.source.SourceFragment
import com.fungo.japan.ui.user.UserFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @author Pinger
 * @since 2018/11/1 21:53
 */
class MainFragment : BaseContentFragment() {

    override fun getContentResID(): Int = R.layout.fragment_main

    override fun initContentView() {
        val fragments = arrayListOf<BaseFragment>()
        fragments.add(HomeFragment())
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

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_study -> showHideFragment(fragments[0])
                R.id.bottom_find -> showHideFragment(fragments[1])
                R.id.bottom_source -> showHideFragment(fragments[2])
                R.id.bottom_user -> showHideFragment(fragments[3])
            }
            true
        }
    }
}