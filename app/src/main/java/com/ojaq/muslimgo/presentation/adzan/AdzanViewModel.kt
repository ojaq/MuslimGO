package com.ojaq.muslimgo.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ojaq.muslimgo.core.data.AdzanRepository
import com.ojaq.muslimgo.core.data.Resource
import com.ojaq.muslimgo.core.domain.model.DailyAdzanResult

class AdzanViewModel(private val adzanRepository: AdzanRepository) : ViewModel() {
    fun getDailyAdzanTime(): LiveData<Resource<DailyAdzanResult>> =
        adzanRepository.getDailyAdzanTimeResult()
}