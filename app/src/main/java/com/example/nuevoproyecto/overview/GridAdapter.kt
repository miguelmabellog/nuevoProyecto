package com.example.nuevoproyecto.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevoproyecto.databinding.GridViewItemBinding
import com.example.nuevoproyecto.network.PostEntity

class GridAdapter( private val onClickListener: OnClickListener ) :
    ListAdapter<PostEntity,
            GridAdapter.PostsViewHolder>(DiffCallback) {

    class OnClickListener(val clickListener: (postEntity:PostEntity) -> Unit) {
        fun onClick(postEntity: PostEntity) = clickListener(postEntity)
    }

    class PostsViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostEntity) {
            binding.post = post
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PostEntity>() {
        override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PostsViewHolder {
        return PostsViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(post)
        }
        holder.bind(post)
    }


}