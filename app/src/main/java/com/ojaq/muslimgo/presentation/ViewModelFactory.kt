package com.ojaq.muslimgo.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.ojaq.muslimgo.core.di.Injection
import com.ojaq.muslimgo.core.di.Injection.provideAdzanRepository
import com.ojaq.muslimgo.presentation.Quran.QuranViewModel
import com.ojaq.muslimgo.presentation.adzan.AdzanViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val context: Context) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(QuranViewModel::class.java) -> {
                QuranViewModel(Injection.provideQuranRepository()) as T
            }
            modelClass.isAssignableFrom(AdzanViewModel::class.java) -> {
                AdzanViewModel(provideAdzanRepository(context)) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }
}