package com.fungo.japan.ui.main

import android.content.Context
import android.view.ViewGroup
import com.fungo.baselib.base.recycler.BaseRecyclerAdapter
import com.fungo.baselib.base.recycler.BaseViewHolder
import com.fungo.imagego.loadImage
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 2018/10/30 20:37
 */
class MainCardAdapter(context: Context) : BaseRecyclerAdapter<MainCardBean>(context) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MainCardBean> {
        return MainCardHolder(parent)
    }

    inner class MainCardHolder(parent: ViewGroup) : BaseViewHolder<MainCardBean>(parent, R.layout.holder_main_card) {
        override fun onBindData(data: MainCardBean) {
            loadImage(data.bgRes, findView(R.id.imageView))
        }

    }

}