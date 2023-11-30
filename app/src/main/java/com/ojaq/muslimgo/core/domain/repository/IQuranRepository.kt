package com.ojaq.muslimgo.core.domain.repository

import com.ojaq.muslimgo.core.data.Resource
import com.ojaq.muslimgo.core.domain.model.QuranEdition
import com.ojaq.muslimgo.core.domain.model.Surah
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {
    fun getListSurah(): Flow<Resource<List<Surah>>>

    fun getDetailSurahWithQuranEdition(number: Int) : Flow<Resource<List<QuranEdition>>>

}