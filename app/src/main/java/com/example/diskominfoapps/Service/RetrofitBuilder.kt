package com.gilbram.newsapi.Service


import android.accessibilityservice.GestureDescription
import com.example.diskominfoapps.Service.ResponseNews
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object RetrofitBuilder {
    private val client = OkHttpClient.Builder().build()

    var gson = GsonBuilder()
        .setLenient()
        .create()

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.bekasikota.go.id/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getService() = retrofit.create(TopHeadLine::class.java)

    interface TopHeadLine {
        @GET("rss")
        fun fetchHeadlines(): Call<ResponseNews>

    }



}
