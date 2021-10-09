package com.example.nuevoproyecto.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevoproyecto.R
import com.example.nuevoproyecto.databinding.GridViewItemBinding
import com.example.nuevoproyecto.network.PostEntity
import com.example.nuevoproyecto.overview.GridAdapter
import kotlinx.android.synthetic.main.grid_view_item.view.*

class FavoriteListAdapter() :
    ListAdapter<PostEntity,
            FavoriteListAdapter.PostsViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): FavoriteListAdapter.PostsViewHolder {
        return FavoriteListAdapter.PostsViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: FavoriteListAdapter.PostsViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PostEntity>() {
        override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class PostsViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostEntity) {
            if(post.favorite==true){
                binding.post = post
                binding.imageView.visibility=View.VISIBLE
                binding.imageView2.visibility=View.VISIBLE
            }else{
                binding.imageView.visibility=View.GONE
                binding.imageView2.visibility=View.GONE
            }
            binding.executePendingBindings()
        }
    }

}


