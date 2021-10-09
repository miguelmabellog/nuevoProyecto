package com.example.nuevoproyecto.pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nuevoproyecto.favorite.FavoriteListFragment
import com.example.nuevoproyecto.overview.OverviewFragment

class PagerAdapter(fa: Fragment):FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position+1){
            1 -> {
                val fragment = OverviewFragment()
                return fragment
            }
            2 -> {
                val fragment = FavoriteListFragment()
                return fragment
            }
            else->{
                val fragment = OverviewFragment()
                return fragment
            }
        }
    }
}