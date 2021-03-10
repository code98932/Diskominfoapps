package com.gilbram.newsapi.Service


import com.example.diskominfoapps.Service.Response
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitBuilder {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.rss2json.com/v1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(client)
        .build()

    fun getService() = retrofit.create(TopHeadLine::class.java)

}
interface TopHeadLine{
    @GET("api.json?rss_url=https%3A%2F%2Fwww.bekasikota.go.id%2Frss")
    fun fetchHeadlines (): Call<Response>
}