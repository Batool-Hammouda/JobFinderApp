package com.example.jopfinderapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(supportFragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(supportFragmentManager,lifecycle){
    override fun getItemCount(): Int {
       return 3
    }

    override fun createFragment(position: Int): Fragment {
      return when(position){
          0->{
              SharedFragment()
          }
        1->{
            SharedFragment()
        }
        else->{
            SharedFragment()
        }
      }
    }

}