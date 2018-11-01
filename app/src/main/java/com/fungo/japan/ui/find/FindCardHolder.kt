package com.fungo.japan.ui.find

import android.text.SpannableString
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.fungo.banner.holder.BaseBannerHolder
import com.fungo.baselib.base.basic.BaseActivity
import com.fungo.imagego.loadImage
import com.fungo.japan.R
import com.fungo.japan.ui.find.detail.FindDetailFragment

/**
 * @author Pinger
 * @since 2018/10/30 20:37
 */
class FindCardHolder : BaseBannerHolder<FindCardBean> {

    override fun getHolderResId(): Int {
        return R.layout.holder_find_card
    }

    override fun onBindData(itemView: View, data: FindCardBean) {
        loadImage(data.imgUrl, itemView.findViewById<ImageView>(R.id.ivCardImage))

        // 日期
        setMonthText(itemView.findViewById(R.id.tvMonth), data.month)
        // 星期
        setWeekText(itemView.findViewById(R.id.tvWeek), data.week)

        // 内容
        setContentText(itemView.findViewById(R.id.tvContent), data.content)

        // 来源
        setFromText(itemView.findViewById(R.id.tvFrom), data.from)
    }

    private fun setMonthText(tvMonth: TextView, month: String) {
        val ss = SpannableString(month)
        ss.setSpan(TextAppearanceSpan(tvMonth.context, R.style.FindWeekCNTextStyle), 0, 3,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(TextAppearanceSpan(tvMonth.context, R.style.FindWeekJPTextStyle), 3,
                month.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvMonth.setText(ss, TextView.BufferType.SPANNABLE)
    }

    private fun setWeekText(tvWeek: TextView, week: String) {
        val ss = SpannableString(week)
        ss.setSpan(TextAppearanceSpan(tvWeek.context, R.style.FindWeekCNTextStyle), 0, 3,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(TextAppearanceSpan(tvWeek.context, R.style.FindWeekJPTextStyle), 3,
                week.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvWeek.setText(ss, TextView.BufferType.SPANNABLE)
    }

    private fun setContentText(tvContent: TextView, content: String) {
        val ss = SpannableString(content)
        ss.setSpan(TextAppearanceSpan(tvContent.context, R.style.FindWeekCNTextStyle), 0, 3,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(TextAppearanceSpan(tvContent.context, R.style.FindWeekJPTextStyle), 3,
                content.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvContent.setText(ss, TextView.BufferType.SPANNABLE)
    }

    private fun setFromText(tvFrom: TextView, from: String) {
        tvFrom.text = from
    }


    override fun onPageClick(itemView: View, position: Int, data: FindCardBean) {
        val context = itemView.context
        if (context is BaseActivity) {
            context.start(FindDetailFragment.newInstant(data))
        }
    }

}