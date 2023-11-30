package com.ojaq.muslimgo.core.data.network.adzan

import retrofit2.http.GET
import retrofit2.http.Path

interface AdzanApiService {
    @GET("sholat/kota/cari/{city}")
    suspend fun searchCity(
        @Path("city") city : String
    ): CityResponses

    @GET("sholat/jadwal/{idCity}/{year}/{month}/{date}")
    suspend fun getDailyAdzanTime(
        @Path("idCity") id: String,
        @Path("year") year: String,
        @Path("month") month: String,
        @Path("date") date: String,
    ): DailyResponse
}