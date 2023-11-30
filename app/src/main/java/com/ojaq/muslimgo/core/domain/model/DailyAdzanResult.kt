package com.ojaq.muslimgo.core.domain.model

import com.ojaq.muslimgo.core.data.Resource

data class DailyAdzanResult(
    val listAddress: List<String>,
    val adzanTime: Resource<Jadwal>,
    val currentDate: List<String>
)