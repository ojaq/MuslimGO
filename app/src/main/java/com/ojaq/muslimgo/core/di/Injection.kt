package com.ojaq.muslimgo.core.di

import android.content.Context
import com.ojaq.muslimgo.core.data.AdzanRepository
import com.ojaq.muslimgo.core.data.RemoteDataSource
import com.ojaq.muslimgo.core.data.QuranRepository
import com.ojaq.muslimgo.core.data.local.CalendarPreferences
import com.ojaq.muslimgo.core.data.local.LocationPreferences
import com.ojaq.muslimgo.core.data.network.ApiConfig
import com.ojaq.muslimgo.core.data.network.ApiConfig.adzanApiService

object Injection {
    private val quranApiService = ApiConfig.quranApiService
    private val adzanApiService = ApiConfig.adzanApiService
    private val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)

    fun provideQuranRepository(): QuranRepository = QuranRepository(remoteDataSource)

    fun provideAdzanRepository(context: Context): AdzanRepository{
        val locationPreferences = LocationPreferences(context)
        val calendarPreferences = CalendarPreferences()
        return AdzanRepository(remoteDataSource, locationPreferences, calendarPreferences)
    }

}