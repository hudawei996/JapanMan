package com.fungo.japan.ui.find.detail

import android.app.Activity
import android.os.Bundle
import com.fungo.baseuilib.fragment.BaseSwipeBackFragment
import com.fungo.baseuilib.theme.UiUtils
import com.fungo.baseuilib.utils.StatusBarUtils
import com.fungo.imagego.loadImage
import com.fungo.japan.R
import com.fungo.japan.ui.find.FindCardBean
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_find_detail.*
import me.yokeyword.fragmentation.anim.DefaultNoAnimator
import me.yokeyword.fragmentation.anim.FragmentAnimator

/**
 * @author Pinger
 * @since 2018/11/1 21:43
 */
class FindDetailFragment : BaseSwipeBackFragment() {

    override fun isShowToolBar(): Boolean = false

    private var mFindCardBean: FindCardBean? = null
    private val mAppBarHeight by lazy {
        appBar.measuredHeight
    }

    private val mToolBarHeight by lazy {
        toolBar.measuredHeight
    }

    companion object {
        @JvmStatic
        fun newInstant(bean: FindCardBean): FindDetailFragment {
            val bundle = Bundle()
            bundle.putParcelable("CARDBEAN", bean)
            val fragment = FindDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initEvent() {
        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val alphaScale = (-verticalOffset) * 1f / (mAppBarHeight - mToolBarHeight)
            alphaView.alpha = alphaScale
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFindCardBean = arguments?.get("CARDBEAN") as FindCardBean?
    }

    override fun getContentResID(): Int = R.layout.fragment_find_detail

    override fun initContentView() {
        toolBar.navigationIcon = UiUtils.getBackIconFont(context!!)
        toolBar.setNavigationOnClickListener {
            onBackClick()
        }

        loadImage(mFindCardBean?.imgUrl, imageView)
    }


    /**
     * 去除Fragment打开动画，使用共享元素动画
     */
    override fun getFragmentAnimator(): FragmentAnimator? {
        return DefaultNoAnimator()
    }

    override fun onSupportVisible() {
        super.onSupportVisible()
        StatusBarUtils.setStatusBarForegroundColor(context as Activity, false)
    }
}