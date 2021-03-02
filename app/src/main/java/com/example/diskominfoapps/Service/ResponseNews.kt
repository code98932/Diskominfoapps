package com.example.diskominfoapps.Service

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseNews(

	@field:SerializedName("berita")
	val berita: List<BeritaItem?>? = null
):Parcelable

@Parcelize
data class BeritaItem(

	@field:SerializedName("i_date")
	val iDate: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("content")
	val content: String? = null
):Parcelable
