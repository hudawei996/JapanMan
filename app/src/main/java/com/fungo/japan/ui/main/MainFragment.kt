package com.fungo.japan.ui.main

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fungo.baselib.base.page.BasePageFragment
import com.fungo.japan.R
import com.fungo.japan.widget.card.CardScaleHelper
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * @author Pinger
 * @since 2018/10/30 20:29
 */
class MainFragment : BasePageFragment() {

    private lateinit var mCardScaleHelper: CardScaleHelper
    private lateinit var mCardAdapter: MainCardAdapter
    private var mBlurRunnable: Runnable? = null
    private var mLastPos = -1
    private val mList = ArrayList<MainCardBean>()

    override fun getPageLayoutResId(): Int {
        return R.layout.fragment_main
    }


    override fun initPageView() {
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mCardAdapter = MainCardAdapter(context!!)
        recyclerView.adapter = mCardAdapter

        // recyclerView绑定scale效果
        mCardScaleHelper = CardScaleHelper()
        mCardScaleHelper.currentItemPos = 3
        mCardScaleHelper.attachToRecyclerView(recyclerView)
    }

    override fun initData() {
        mList.add(MainCardBean("", "", R.mipmap.pic4))
        mList.add(MainCardBean("", "", R.mipmap.pic5))
        mList.add(MainCardBean("", "", R.mipmap.pic6))
        mList.add(MainCardBean("", "", R.mipmap.pic4))
        mList.add(MainCardBean("", "", R.mipmap.pic5))
        mList.add(MainCardBean("", "", R.mipmap.pic6))
        mCardAdapter.addAll(mList)

        initBlurBackground()
    }

    private fun initBlurBackground() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    notifyBackgroundChange()
                }
            }
        })
        notifyBackgroundChange()
    }

    private fun notifyBackgroundChange() {
        if (mLastPos == mCardScaleHelper.currentItemPos) return
        mLastPos = mCardScaleHelper.currentItemPos
        val bean = mList[mCardScaleHelper.currentItemPos]
    }


    fun startSwitchBackgroundAnim(view: ImageView, bitmap: Bitmap) {
        val oldDrawable = view.getDrawable()
        val oldBitmapDrawable: Drawable
        var oldTransitionDrawable: TransitionDrawable? = null
        if (oldDrawable is TransitionDrawable) {
            oldTransitionDrawable = oldDrawable
            oldBitmapDrawable = oldTransitionDrawable!!.findDrawableByLayerId(oldTransitionDrawable.getId(1))
        } else if (oldDrawable is BitmapDrawable) {
            oldBitmapDrawable = oldDrawable
        } else {
            oldBitmapDrawable = ColorDrawable(-0x3d3d3e)
        }

        if (oldTransitionDrawable == null) {
            oldTransitionDrawable = TransitionDrawable(arrayOf(oldBitmapDrawable, BitmapDrawable(bitmap)))
            oldTransitionDrawable.setId(0, 0)
            oldTransitionDrawable.setId(1, 1)
            oldTransitionDrawable.isCrossFadeEnabled = true
            view.setImageDrawable(oldTransitionDrawable)
        } else {
            oldTransitionDrawable.setDrawableByLayerId(oldTransitionDrawable.getId(0), oldBitmapDrawable)
            oldTransitionDrawable.setDrawableByLayerId(oldTransitionDrawable.getId(1), BitmapDrawable(bitmap))
        }
        oldTransitionDrawable.startTransition(1000)
    }


    override fun isSwipeBackEnable(): Boolean = false

    override fun isShowBackIcon(): Boolean = false

    override fun getPageTitle(): String? {
        return getString(R.string.app_name)
    }
}