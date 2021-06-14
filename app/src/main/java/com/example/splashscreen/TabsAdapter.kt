package com.example.splashscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class TabsAdapter (supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val fragmentList =ArrayList<Fragment>()
    private val fragmentTitles = ArrayList<String>()


    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
        return fragmentList [position]
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
         return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

    fun addFragments(fragment: Fragment, fragmentTitle: String){

        fragmentList.add(fragment)
        fragmentTitles.add(fragmentTitle)
    }
}