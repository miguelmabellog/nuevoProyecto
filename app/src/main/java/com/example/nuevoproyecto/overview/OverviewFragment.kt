package com.example.nuevoproyecto.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.nuevoproyecto.R
import com.example.nuevoproyecto.databinding.FragmentOverviewBinding
import com.example.nuevoproyecto.network.PostEntity
import com.example.nuevoproyecto.pager.PagerFragmentDirections


class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner=this

        binding.viewModel=viewModel

        val overviewAdapter = OverviewAdapter (OverviewAdapter.OnClickListener({
            viewModel.displayItemDetails(it)
        },{
            it.favorite = !it.favorite

        }))

        binding.adapterGrid.adapter=overviewAdapter

        viewModel.posts.observe(viewLifecycleOwner, Observer {
            overviewAdapter.submitList(it)
        })

        ItemTouchHelper(ItemSwipeHandler(overviewAdapter) { removeItem(it) }).attachToRecyclerView(binding.adapterGrid)


        /*binding.adapterGrid.adapter=GridAdapter(GridAdapter.OnClickListener({
            viewModel.displayItemDetails(it)
        },{
            if(it.favorite){
                it.favorite=false
            }else{
                it.favorite=true
            }

        })

        )*/



        viewModel.navigateToSelectedItem.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                it.read=true

                parentFragment?.view?.findNavController()
                    ?.navigate(PagerFragmentDirections.actionPagerFragmentToDetailFragment(it))
                viewModel.displayItemDetailsComplete()
            }
        })

        viewModel.eventGetPost.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                viewModel.getPosts()
            }
        })

        binding.button.setOnClickListener {
            viewModel.clearPost()
        }

        binding.button2.setOnClickListener {
            viewModel.getPosts()
        }


        return binding.root
    }

    private fun removeItem(product: PostEntity) {
        //products.remove(product)

    }


}