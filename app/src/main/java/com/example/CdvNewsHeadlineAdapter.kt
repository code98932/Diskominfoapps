package com.example

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.size.Scale
import coil.api.load
import com.example.diskominfoapps.DetailActivity
import com.example.diskominfoapps.Service.BeritaItem
import com.example.diskominfoapps.databinding.CdvNewsHeadlineBinding

class CdvNewsHeadlineAdapter : RecyclerView.Adapter<CdvNewsHeadlieVH>(){
    private val listData = ArrayList<BeritaItem>()
    fun addData(items: List<BeritaItem>){
        listData.clear()
        listData.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvNewsHeadlieVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CdvNewsHeadlineBinding.inflate(layoutInflater, parent, false)
        return CdvNewsHeadlieVH(binding)
    }
    override fun getItemCount(): Int {
        return listData.size
    }
    override fun onBindViewHolder(holder: CdvNewsHeadlieVH, position: Int) {
        holder.bind(listData[position])
    }
}
class CdvNewsHeadlieVH(private val binding: CdvNewsHeadlineBinding) :
    RecyclerView.ViewHolder(binding.root){
    fun bind(article: BeritaItem){
        binding.run {
            txtTitle.text = cropText(article.judul?: "Tidak ada judul")
            txtSubtitle.text = article.id
            imgHeadline.apply {
                load(article.gambar){
                    scale(Scale.FILL)
                }
                contentDescription = article.content
            }
            root.setOnClickListener {
                val intent = Intent(it.context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.DETAIL_NEWS, article)
                }
                it.context.startActivity(intent)
            }
        }
    }
    private fun cropText(text: String): String {
        return text.take(50) + if (text.length > 50)"..." else ""
    }
}