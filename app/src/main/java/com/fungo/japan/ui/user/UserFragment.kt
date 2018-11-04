package com.fungo.japan.ui.user

import android.app.Activity
import com.fungo.baseuilib.fragment.BaseContentFragment
import com.fungo.baseuilib.utils.StatusBarUtils
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 2018/10/31 21:14
 *
 * 用户中心页面，用户用于登陆，查看自我信息等
 *
 */
class UserFragment : BaseContentFragment() {

    override fun getContentResID(): Int = R.layout.fragment_user

    override fun onSupportVisible() {
        super.onSupportVisible()
        StatusBarUtils.setStatusBarForegroundColor(context as Activity, false)
    }
}