package com.ojaq.muslimgo.presentation.Quran

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ojaq.muslimgo.core.data.QuranRepository
import com.ojaq.muslimgo.core.data.Resource
import com.ojaq.muslimgo.core.domain.model.QuranEdition
import com.ojaq.muslimgo.core.domain.model.Surah

class QuranViewModel(private val quranRepository: QuranRepository) : ViewModel() {
    fun getListSurah(): LiveData<Resource<List<Surah>>> = quranRepository.getListSurah().asLiveData()

    fun getDetailSurahWithQuranEdition(number: Int): LiveData<Resource<List<QuranEdition>>> =
        quranRepository.getDetailSurahWithQuranEdition(number).asLiveData()
}