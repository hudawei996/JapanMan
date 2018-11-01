package com.fungo.japan.ui.home

import android.app.Activity
import com.fungo.baselib.base.page.BasePageFragment
import com.fungo.baselib.utils.StatusBarUtils
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 2018/10/31 21:21
 *
 * 第一页Fragment页面，学习日语页面
 *
 */
class HomeFragment : BasePageFragment() {

    override fun getPageTitle(): String? = "我是主页面"

    override fun isShowBackIcon(): Boolean = false

    override fun getPageLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initPageView() {
    }


    override fun onSupportVisible() {
        super.onSupportVisible()
        StatusBarUtils.setStatusBarForegroundColor(context as Activity, false)
    }

}