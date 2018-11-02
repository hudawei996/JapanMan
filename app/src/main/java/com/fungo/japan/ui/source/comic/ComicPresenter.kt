package com.fungo.japan.ui.source.comic

import com.fungo.baselib.base.recycler.BaseRecyclerContract

/**
 * @author Pinger
 * @since 18-11-2 上午11:12
 */
class ComicPresenter(private val comicView: BaseRecyclerContract.View) : BaseRecyclerContract.Presenter {


    override fun loadData(page: Int) {
        val data = arrayListOf<ComicBean>()
        for (i in page * 20..20 * (page + 1)) {
            data.add(ComicBean("我是标题的家啊$i"))
        }
        comicView.showContent(data)
    }
}