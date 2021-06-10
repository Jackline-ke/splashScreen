package com.example.splashscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//The viewPagerAdapter needs to extend(:) FragmentStateAdapter
//We pass two arguments; FragmentManager and LifeCycle
//Then we override two methods (getItemCount and createFragment)

class viewPagerAdapter(list: ArrayList<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {

    //create an arrayList that will hold the Fragments
    private val fragmentList: ArrayList<Fragment> = list

    override fun getItemCount(): Int {
        //return fragmentList size
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        //return fragmentList position
        return fragmentList[position]
    }
}