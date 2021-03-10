package com.example.diskominfoapps.Service

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(

	@field:SerializedName("feed")
	val feed: Feed? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
):Parcelable

@Parcelize
data class ItemsItem(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

//	@field:SerializedName("enclosure")
//	val enclosure: Enclosure? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("guid")
	val guid: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

//	@field:SerializedName("categories")
//	val categories: List<Any?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

//	@field:SerializedName("pubDate")
//	val pubDate: Any?,

	@field:SerializedName("content")
	val content: String? = null
):Parcelable

@Parcelize
data class Feed(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
):Parcelable

//@Parcelize
//data class Enclosure(
//	val any: Any? = null
//):Parcelable

