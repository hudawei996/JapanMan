package com.fungo.japan.ui.source

import android.app.Activity
import com.fungo.baselib.adapter.BaseFragmentPageAdapter
import com.fungo.baseuilib.fragment.BaseContentFragment
import com.fungo.baseuilib.fragment.BaseFragment
import com.fungo.baseuilib.utils.StatusBarUtils
import com.fungo.japan.R
import com.fungo.japan.ui.source.comic.ComicFragment
import kotlinx.android.synthetic.main.fragment_source.*

/**
 * @author Pinger
 * @since 2018/10/31 21:11
 * 资源页面，包括日语动画，图片，书籍等资源
 * 或者学习资料等
 */
class SourceFragment : BaseContentFragment() {

    override fun getContentResID(): Int = R.layout.fragment_source

    override fun onSupportVisible() {
        super.onSupportVisible()
        StatusBarUtils.setStatusBarForegroundColor(context as Activity, false)
    }

    override fun initContentView() {
        StatusBarUtils.setStatusBarHeight(statusView)
        val titles = arrayListOf(
                "动漫",
                "壁纸",
                "新闻",
                "资料"
        )
        val fragments = arrayListOf<BaseFragment>(
                ComicFragment(),
                ComicFragment(),
                ComicFragment(),
                ComicFragment()
        )

        val adapter = BaseFragmentPageAdapter(childFragmentManager)
        adapter.setData(fragments, titles)
        sourceViewPager.adapter = adapter
        sourceViewPager.offscreenPageLimit = fragments.size
        sourceTabLayout.setupWithViewPager(sourceViewPager)
    }
}