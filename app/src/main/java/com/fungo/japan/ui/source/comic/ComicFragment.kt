package com.fungo.japan.ui.source.comic

import com.fungo.baselib.base.recycler.BaseRecyclerContract
import com.fungo.baselib.base.recycler.BaseRecyclerFragment

/**
 * @author Pinger
 * @since 18-11-2 上午11:11
 */
class ComicFragment : BaseRecyclerFragment() {


    override fun isShowToolBar(): Boolean = false

    override fun isSwipeBackEnable(): Boolean = false


    override fun getPresenter(): BaseRecyclerContract.Presenter {
        return ComicPresenter(this)
    }


    override fun initRecyView() {
        register(ComicBean::class.java, ComicHolder())
    }
}