package com.example.nuevoproyecto.pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nuevoproyecto.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_pager.*


class PagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter=PagerAdapter(this)
        pager.adapter=adapter
        /* Menu de seleccion entre las dos pantallas  */
        val tabLayoutMediator= TabLayoutMediator(tab_layout,pager,
            TabLayoutMediator.TabConfigurationStrategy{ tab, position->
                when (position+1){
                    1->tab.text="Lista"
                    2->tab.text="Favoritos"
                }
            })

        tabLayoutMediator.attach()
    }

}