package com.fungo.japan.ui.find

import android.app.Activity
import com.fungo.banner.BannerView
import com.fungo.banner.holder.BannerHolderCreator
import com.fungo.baselib.base.page.BasePageFragment
import com.fungo.baselib.utils.StatusBarUtils
import com.fungo.japan.R
import com.fungo.japan.data.DataProvider
import me.yokeyword.fragmentation.anim.DefaultNoAnimator
import me.yokeyword.fragmentation.anim.FragmentAnimator

/**
 * @author Pinger
 * @since 2018/10/31 21:10
 *
 * 每日一句日语的发现页面
 *
 */
class FindFragment : BasePageFragment() {

    private val mBannerView by lazy {
        findView<BannerView<FindCardBean>>(R.id.bannerView)
    }

    override fun getPageLayoutResId(): Int {
        return R.layout.fragment_find
    }

    override fun isShowToolBar(): Boolean = false

    override fun initPageView() {
        showPageLoading()
    }


    override fun initData() {


//        https@ //fanyi.baidu.com/transapi?from=auto&to=jp&query=%E5%8F%AF%E7%88%B1





        // 翻译接口，翻译今天的日期
        // 数据接口读取今日推荐
        mBannerView.setPages(DataProvider.provideCardData(10), object : BannerHolderCreator<FindCardBean, FindCardHolder> {
            override fun onCreateBannerHolder(): FindCardHolder {
                return FindCardHolder()
            }
        })
        hidePageLoading()
    }


    /**
     * 去除Fragment打开动画，使用共享元素动画
     */
    override fun getFragmentAnimator(): FragmentAnimator? {
        return DefaultNoAnimator()
    }

    override fun onSupportVisible() {
        StatusBarUtils.setStatusBarForegroundColor(context as Activity, true)
        super.onSupportVisible()
    }
}