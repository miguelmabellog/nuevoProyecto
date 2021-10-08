package com.example.nuevoproyecto.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuevoproyecto.network.MyApi
import com.example.nuevoproyecto.network.PostEntity
import kotlinx.coroutines.launch

class OverviewViewModel:ViewModel() {
    private val _posts = MutableLiveData<List<PostEntity>>()

    val posts: LiveData<List<PostEntity>>
        get() = _posts


    init {
        getPosts()
    }
    private fun getPosts() {
        viewModelScope.launch {

            try {
                _posts.value = MyApi.retrofitService.getProperties()
            } catch (e: Exception) {
                Log.i("Error","Error al cargar posts")
            }
        }
    }

}