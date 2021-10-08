package com.example.nuevoproyecto.overview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevoproyecto.network.PostEntity

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PostEntity>?) {
    val adapter = recyclerView.adapter as GridAdapter
    adapter.submitList(data)
}