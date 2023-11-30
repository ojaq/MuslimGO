package com.ojaq.muslimgo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ojaq.muslimgo.core.domain.model.Surah
import com.ojaq.muslimgo.databinding.ItemSurahBinding
import com.ojaq.muslimgo.presentation.Quran.DetailSurahActivity

class QuranAdapter : RecyclerView.Adapter<QuranAdapter.MyViewHolder>() {
    private val listSurah = ArrayList<Surah>()

    fun setData(list: List<Surah>?) {
        if (list == null) return
        listSurah.clear()
        listSurah.addAll(list)
    }

    class MyViewHolder(val binding: ItemSurahBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listSurah.size

    override fun onBindViewHolder(holder: QuranAdapter.MyViewHolder, position: Int) {
        val data = listSurah[position]
        holder.binding.apply {
            tvNumber.text = data.number.toString()
            tvName.text = data.name
            tvSurah.text = data.englishName
            val revelation = data.revelationType
            val numberOfAyah = data.numberOfAyahs
            val resultOfTextAyah = "$revelation - $numberOfAyah Ayahs"
            tvAyah.text = resultOfTextAyah

            this.root.setOnClickListener{
                val intent = Intent(it.context, DetailSurahActivity::class.java)
                intent.putExtra(DetailSurahActivity.EXTRA_DATA, data)
                it.context.startActivity(intent)
            }
        }
    }
}
