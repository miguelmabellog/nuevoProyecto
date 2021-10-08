package com.example.nuevoproyecto.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nuevoproyecto.network.PostEntity

class DetailViewModelFactory (
    private val post: PostEntity,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(post, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}