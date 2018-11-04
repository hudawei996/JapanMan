package com.fungo.japan.ui.source.comic

import com.fungo.baseuilib.recycler.BaseRecyclerContract
import com.fungo.baseuilib.recycler.BaseRecyclerFragment

/**
 * @author Pinger
 * @since 18-11-2 上午11:11
 */
class ComicFragment : BaseRecyclerFragment() {

    override fun isShowToolBar(): Boolean = false

    override fun getPresenter(): BaseRecyclerContract.Presenter = ComicPresenter(this)

    override fun initPageView() {
        register(ComicBean::class.java, ComicHolder())
    }
}