package com.example.nuevoproyecto.overview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevoproyecto.favorite.FavoriteListAdapter
import com.example.nuevoproyecto.network.PostEntity

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PostEntity>?) {
    val adapter = recyclerView.adapter as GridAdapter
    adapter.submitList(data)
}

@BindingAdapter("favoriteListData")
fun bindFavoriteRecyclerView(recyclerView: RecyclerView, data: List<PostEntity>?) {
    val submitData= mutableListOf<PostEntity>()
    data?.forEach {
        if(it.favorite==true){
            submitData.add(it)
        }
    }
    val adapter = recyclerView.adapter as? FavoriteListAdapter
    adapter?.submitList(submitData)
}