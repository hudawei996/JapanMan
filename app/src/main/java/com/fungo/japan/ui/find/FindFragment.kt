package com.fungo.japan.ui.find

import androidx.viewpager.widget.ViewPager
import com.fungo.banner.BannerView
import com.fungo.banner.holder.BannerHolderCreator
import com.fungo.baselib.base.page.BasePageFragment
import com.fungo.imagego.loadBlur
import com.fungo.japan.R
import kotlinx.android.synthetic.main.fragment_find.*

/**
 * @author Pinger
 * @since 2018/10/31 21:10
 *
 * 每日一句日语的发现页面
 *
 */
class FindFragment : BasePageFragment() {

    private val mList = ArrayList<FindCardBean>()

    private val mBannerView by lazy {
        findView<BannerView<FindCardBean>>(R.id.bannerView)
    }

    override fun getPageLayoutResId(): Int {
        return R.layout.fragment_find
    }


    override fun isShowToolBar(): Boolean = false


    override fun initData() {
        // 翻译接口，翻译今天的日期

        // 数据接口读取今日推荐


        mList.add(FindCardBean("", "", "", R.mipmap.pic4))
        mList.add(FindCardBean("", "", "", R.mipmap.pic5))
        mList.add(FindCardBean("", "", "", R.mipmap.pic6))
        mList.add(FindCardBean("", "", "", R.mipmap.pic4))
        mList.add(FindCardBean("", "", "", R.mipmap.pic5))
        mList.add(FindCardBean("", "", "", R.mipmap.pic6))
        mBannerView.setPages(mList, object : BannerHolderCreator<FindCardBean, FindCardHolder> {
            override fun onCreateBannerHolder(): FindCardHolder {
                return FindCardHolder()
            }
        })
        loadBlur(mList[0].bgRes, blurView)
    }

    override fun initEvent() {
        mBannerView.addPageChangeLisnter(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                loadBlur(mList[position].bgRes, blurView)
            }
        })
    }
}