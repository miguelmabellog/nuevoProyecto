package com.example.nuevoproyecto.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.nuevoproyecto.R
import com.example.nuevoproyecto.databinding.FragmentFavoriteListBinding
import com.example.nuevoproyecto.databinding.FragmentOverviewBinding
import com.example.nuevoproyecto.network.PostEntity
import com.example.nuevoproyecto.overview.GridAdapter
import com.example.nuevoproyecto.overview.OverviewViewModel


class FavoriteListFragment : Fragment() {

    private val viewModel: OverviewViewModel by activityViewModels()
    private lateinit var binding:FragmentFavoriteListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFavoriteListBinding.inflate(inflater)

        binding.lifecycleOwner=this


        binding.viewModel=viewModel





        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val adapter=GridAdapter(GridAdapter.OnClickListener({
            viewModel.displayItemDetails(it)
        },{


        })

        )
        binding.favoriteRecycler.adapter=adapter
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            val submitData= mutableListOf<PostEntity>()
            it?.forEach {post->
                if(post.favorite==true){
                    submitData.add(post)
                }
            }
            adapter?.submitList(submitData)
        })
    }


}