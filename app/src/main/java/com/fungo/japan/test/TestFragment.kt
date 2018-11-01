package com.fungo.japan.test

import com.fungo.baselib.base.basic.BaseFragment
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 2018/11/1 23:43
 */
class TestFragment : BaseFragment() {

    override val layoutResID: Int
        get() = R.layout.fragment_test

    override fun isSwipeBackEnable(): Boolean  = false
}