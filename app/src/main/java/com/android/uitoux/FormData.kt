package com.android.uitoux

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class FormData(var title: String, var answer: String) : Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(answer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FormData> {
        override fun createFromParcel(parcel: Parcel): FormData {
            return FormData(parcel)
        }

        override fun newArray(size: Int): Array<FormData?> {
            return arrayOfNulls(size)
        }
    }
}