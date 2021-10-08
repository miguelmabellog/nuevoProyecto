package com.example.nuevoproyecto.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nuevoproyecto.network.PostEntity

class DetailViewModel( post: PostEntity,
                       app: Application
): AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<PostEntity>()

    val selectedProperty: LiveData<PostEntity>
        get() = _selectedProperty

    init {
        _selectedProperty.value = post
    }
}