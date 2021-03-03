package com.example.diskominfoapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.CdvNewsHeadlineAdapter
import com.example.diskominfoapps.databinding.ActivityMainBinding
import com.gilbram.newsapi.Service.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterRv: CdvNewsHeadlineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.plant(Timber.DebugTree())
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapterRv = CdvNewsHeadlineAdapter()
        binding.run {
            setContentView(root)
//            setSupportActionBar(toolBar)


            main_rv.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = adapterRv
            }

            val call =  RetrofitBuilder.getService().fetchHeadlines()
            call.enqueue(object : Callback<com.example.diskominfoapps.Service.ResponseNews> {
                override fun onFailure(call: Call<com.example.diskominfoapps.Service.ResponseNews>, t: Throwable) {
                    Timber.e(t)
                    Toast.makeText(applicationContext,t.message.toString(), Toast.LENGTH_SHORT).show()

                }
                override fun onResponse(
                    call: Call<com.example.diskominfoapps.Service.ResponseNews>,
                    response: Response<com.example.diskominfoapps.Service.ResponseNews>
                ) {
                    response.body()?.berita?.let {
                        adapterRv.addData(it)
                    }
                }
            })
        }
    }
}