package com.fungo.japan.ui.find

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Pinger
 * @since 2018/10/30 21:06
 */
data class FindCardBean(val imgUrl: String, val month: String, val week: String, val content: String, val from: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imgUrl)
        parcel.writeString(month)
        parcel.writeString(week)
        parcel.writeString(content)
        parcel.writeString(from)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FindCardBean> {
        override fun createFromParcel(parcel: Parcel): FindCardBean {
            return FindCardBean(parcel)
        }

        override fun newArray(size: Int): Array<FindCardBean?> {
            return arrayOfNulls(size)
        }
    }
}