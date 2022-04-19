package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable

class Quora(private var version: Double, private var update: String?) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "Quora{" +
                "version=" + version +
                ", update='" + update + '\'' +
                '}'
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(version)
        parcel.writeString(update)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Quora> {
        override fun createFromParcel(parcel: Parcel): Quora {
            return Quora(parcel)
        }

        override fun newArray(size: Int): Array<Quora?> {
            return arrayOfNulls(size)
        }
    }

}