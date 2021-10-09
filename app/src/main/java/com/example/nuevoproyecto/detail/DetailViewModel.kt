package com.example.nuevoproyecto.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nuevoproyecto.network.MyApi
import com.example.nuevoproyecto.network.PostEntity
import com.example.nuevoproyecto.network.User
import kotlinx.coroutines.launch

class DetailViewModel( post: PostEntity,
                       app: Application
): AndroidViewModel(app) {

    private val _listUser = MutableLiveData<List<User>>()

    val listUser: LiveData<List<User>>
        get() = _listUser

    private val _selectedProperty = MutableLiveData<PostEntity>()

    val selectedProperty: LiveData<PostEntity>
        get() = _selectedProperty

    init {
        _selectedProperty.value = post
        getUser(post.userId)
    }

    private fun getUser(filter: Int) {
        viewModelScope.launch {

            try {
                _listUser.value = MyApi.retrofitService.getUsers(filter)
            } catch (e: Exception) {
                Log.i("Error","Error en detailViewModel")
            }
        }
    }
}