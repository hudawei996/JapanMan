package com.fungo.japan.ui.home

import android.app.Activity
import com.fungo.baseuilib.fragment.BaseContentFragment
import com.fungo.baseuilib.utils.StatusBarUtils
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 2018/10/31 21:21
 *
 * 第一页Fragment页面，学习日语页面
 *
 */
class HomeFragment : BaseContentFragment() {

    override fun getContentResID(): Int = R.layout.fragment_home

    override fun onSupportVisible() {
        super.onSupportVisible()
        StatusBarUtils.setStatusBarForegroundColor(context as Activity, false)
    }

}