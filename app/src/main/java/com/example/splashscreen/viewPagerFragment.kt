package com.example.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class viewPagerFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //storing the inflate in the view val(variable)
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        //create a fragmentList and then pass the fragments
        val fragmentList: ArrayList<Fragment> = arrayListOf(
                Fragment1(),
                Fragment2(),
                Fragment3()
        )
        //create an adapter variable then initialize the viewPagerAdapter
        val viewPager2: ViewPager2 = view.findViewById(R.id.viewPager)
        val adapter = viewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
        viewPager2.adapter = adapter

        return view
    }
}