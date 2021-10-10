package com.example.nuevoproyecto.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.nuevoproyecto.network.PostEntity


object DiffCallbackPost: DiffUtil.ItemCallback<PostEntity>() {

    override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
        return oldItem.id == newItem.id
    }
}