package com.fungo.japan.data

import com.fungo.japan.ui.find.FindCardBean

/**
 * @author Pinger
 * @since 2018/11/1 21:13
 */
object DataProvider {

    fun provideCardData(size: Int): List<FindCardBean> {
        val data = arrayListOf<FindCardBean>()
        for (i in 0..size) {
            data.add(FindCardBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1541078129&di=0ac8206709005c10f5764aecf3f29b48&src=http://p2.gexing.com/G1/M00/DB/CA/rBACFFcI30GyXyQ2ABKjMy1Cyds705.jpg"
            ,"11号 11月\njust like    maybe i will"
            ,"木曜日\n week"
            ,"It's going to be a hot day. So we must cry. Rudge's bones and bones sleep every day.\n天将降大热私人也，必须哭泣心智，拉奇筋骨，天天睡觉。"
            ,"-- 三个字：你猜吧"))
        }
        return data
    }


}