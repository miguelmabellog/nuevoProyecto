package com.example.nuevoproyecto.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nuevoproyecto.R
import com.example.nuevoproyecto.databinding.FragmentDetailBinding
import com.example.nuevoproyecto.overview.OverviewViewModel


class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val selectedPost = DetailFragmentArgs.fromBundle(requireArguments()).selectedPost

        val viewModelFactory = DetailViewModelFactory(selectedPost, application)
        viewModel=ViewModelProvider(
            this, viewModelFactory).get(DetailViewModel::class.java)
        binding.viewModel = viewModel




        return binding.root
    }



}