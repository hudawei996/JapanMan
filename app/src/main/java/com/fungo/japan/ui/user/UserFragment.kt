package com.fungo.japan.ui.user

import android.app.Activity
import com.fungo.baselib.base.page.BasePageFragment
import com.fungo.baselib.utils.StatusBarUtils
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 2018/10/31 21:14
 *
 * 用户中心页面，用户用于登陆，查看自我信息等
 *
 */
class UserFragment : BasePageFragment() {

    override fun isShowToolBar(): Boolean = false

    override fun getPageLayoutResId(): Int {
        return R.layout.fragment_user
    }

    override fun onSupportVisible() {
        super.onSupportVisible()
        StatusBarUtils.setStatusBarForegroundColor(context as Activity, false)
    }
}