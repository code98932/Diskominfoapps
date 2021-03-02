package com.example.diskominfoapps.Service

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Berita(
    @SerializedName("content")
    val content: String,
    @SerializedName("gambar")
    val gambar: String,
    @SerializedName("i_date")
    val i_date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("judul")
    val judul: String
):Parcelable