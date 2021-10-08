package com.example.nuevoproyecto.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nuevoproyecto.R
import com.example.nuevoproyecto.databinding.FragmentOverviewBinding


class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner=this

        binding.viewModel=viewModel
        binding.adapterGrid.adapter=GridAdapter(GridAdapter.OnClickListener{

        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }




}