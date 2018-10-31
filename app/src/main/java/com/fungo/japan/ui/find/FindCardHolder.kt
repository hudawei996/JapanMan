package com.fungo.japan.ui.find

import android.view.View
import android.widget.ImageView
import com.fungo.banner.holder.BaseBannerHolder
import com.fungo.japan.R

/**
 * @author Pinger
 * @since 2018/10/30 20:37
 */
class FindCardHolder : BaseBannerHolder<FindCardBean> {

    override fun getHolderResId(): Int {
        return R.layout.holder_find_card
    }

    override fun onBindData(itemView: View, data: FindCardBean) {
        itemView.findViewById<ImageView>(R.id.imageView).setImageResource(data.bgRes)
    }


}