package com.fungo.japan.ui.source.comic

import android.view.ViewGroup
import com.fungo.baselib.base.recycler.BaseViewHolder
import com.fungo.baselib.base.recycler.multitype.MultiTypeViewHolder
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 18-11-2 上午11:17
 */
class ComicHolder : MultiTypeViewHolder<ComicBean, ComicHolder.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup): ViewHolder {
        return ViewHolder(p0)
    }


    class ViewHolder(parent: ViewGroup) : BaseViewHolder<ComicBean>(parent, R.layout.holder_comic) {
        override fun onBindData(data: ComicBean) {
            setText(R.id.textView, data.title)
        }

    }

}