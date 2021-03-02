package com.example.diskominfoapps.Service

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("berita")
	val berita: List<BeritaItem?>? = null
)

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
)
