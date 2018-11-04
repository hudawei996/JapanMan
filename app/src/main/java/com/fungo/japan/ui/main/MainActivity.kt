package com.fungo.japan.ui.main

import com.fungo.baseuilib.activity.BaseContentActivity
import com.fungo.baseuilib.fragment.BaseFragment


/**
 * 第一个Activity，主要用来分发页面
 * 暂时用来做主页，后面会分成多个Fragment
 */
class MainActivity : BaseContentActivity() {

    override fun getContentFragment(): BaseFragment = MainFragment()

}
