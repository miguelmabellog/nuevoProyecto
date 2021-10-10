package com.example.nuevoproyecto.overview

import android.view.View
import android.view.ViewGroup
import com.example.nuevoproyecto.R
import com.example.nuevoproyecto.databinding.GridViewItemBinding
import com.example.nuevoproyecto.databinding.ItemEmptyBinding
import com.example.nuevoproyecto.network.PostEntity
import com.example.nuevoproyecto.utils.DiffCallbackPost
import com.example.nuevoproyecto.utils.ListAdapterEmptyItemSwipeable

class OverviewAdapter(
    private val onClickListener: OnClickListener
): ListAdapterEmptyItemSwipeable<PostEntity, OverviewAdapter.ProductViewHolder>(DiffCallbackPost) {

    class OnClickListener(val clickListener: (postEntity:PostEntity) -> Unit,
                          val clickFavorite:(postEntity:PostEntity)->Unit) {
        fun onClick(postEntity: PostEntity) = clickListener(postEntity)
        fun onClickFavorite(postEntity: PostEntity)=clickFavorite(postEntity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return if (viewType == typeData) ProductViewHolder(R.layout.grid_view_item, parent)
        else ProductViewHolder(R.layout.grid_view_item, parent)
    }

    inner class ProductViewHolder(layout: Int, parent: ViewGroup): ViewHolder(layout, parent) {
        val binding=GridViewItemBinding.bind(itemView)
        override fun bindData(post: PostEntity) {

            binding.post=post
            binding.executePendingBindings()

            if(post.id>20 || post.read){
                binding.imageView2.visibility= View.GONE
            }else{
                binding.imageView2.visibility= View.VISIBLE
            }
            binding.imageView.setImageResource(
                if(post.favorite){
                    R.drawable.ic_favorite
                }else{
                    R.drawable.ic_favorite_border
                }

            )
            binding.textView.setOnClickListener {
                onClickListener.onClick(post)
            }

            binding.imageView.setOnClickListener {
                onClickListener.onClickFavorite(post)
                notifyDataSetChanged()
            }


        }

        override fun bindEmpty() {


        }
    }
}