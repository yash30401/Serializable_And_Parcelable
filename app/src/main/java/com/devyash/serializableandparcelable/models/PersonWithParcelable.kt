package com.devyash.serializableandparcelable.models

import android.os.Parcel
import android.os.Parcelable

data class PersonWithParcelable(
    val id: Int? = 0,
    val name: String? = "",
    val address: String? = "",
    val age:Int? = 18
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeValue(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonWithParcelable> {
        override fun createFromParcel(parcel: Parcel): PersonWithParcelable {
            return PersonWithParcelable(parcel)
        }

        override fun newArray(size: Int): Array<PersonWithParcelable?> {
            return arrayOfNulls(size)
        }
    }
}