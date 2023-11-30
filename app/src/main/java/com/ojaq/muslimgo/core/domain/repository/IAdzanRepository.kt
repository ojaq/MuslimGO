package com.ojaq.muslimgo.core.domain.repository

import androidx.lifecycle.LiveData
import com.ojaq.muslimgo.core.data.Resource
import com.ojaq.muslimgo.core.domain.model.City
import com.ojaq.muslimgo.core.domain.model.Jadwal
import kotlinx.coroutines.flow.Flow

interface IAdzanRepository {
    fun getLocation(): LiveData<List<String>>
    fun searchCity(city: String): Flow<Resource<List<City>>>
    fun getDailyAdzanTime(
        id: String,
        year: String,
        month: String,
        date: String
    ): Flow<Resource<Jadwal>>
}