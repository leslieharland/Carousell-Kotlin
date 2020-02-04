package com.example.leslie.persistence.service

import android.os.Parcel
import android.os.Parcelable

data class Listings(
        val listings: List<ListingItem>) : Parcelable {
    companion object {
        @Suppress("unused")
        @JvmField val CREATOR: Parcelable.Creator<Listings> = object : Parcelable.Creator<Listings> {
            override fun createFromParcel(source: Parcel): Listings = Listings(source)
            override fun newArray(size: Int): Array<Listings?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this( source.createTypedArrayList(ListingItem.CREATOR))
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(listings)
    }

    override fun describeContents(): Int {
        return 0
    }

}


data class ListingItem(
        var text: String,
        var condition: String,
        var price: Number,
        var description: String
) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString())
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<ListingItem> = object : Parcelable.Creator<ListingItem> {
            override fun createFromParcel(source: Parcel): ListingItem = ListingItem(source)
            override fun newArray(size: Int): Array<ListingItem?> = arrayOfNulls(size)
        }
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
        parcel.writeString(condition)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }



}