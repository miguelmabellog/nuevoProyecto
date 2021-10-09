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

    private val _navigateToSelectedItem = MutableLiveData<PostEntity>()
    val navigateToSelectedItem: LiveData<PostEntity>
        get() = _navigateToSelectedItem


    init {
        getPosts()
    }
    private fun getPosts() {
        viewModelScope.launch {

            try {
                _posts.value = MyApi.retrofitService.getPosts()
            } catch (e: Exception) {
                Log.i("Error","Error al cargar posts")
            }
        }
    }

    fun displayItemDetails(post: PostEntity) {
        _navigateToSelectedItem.value = post
    }

    fun displayItemDetailsComplete() {
        _navigateToSelectedItem.value = null

    }

}