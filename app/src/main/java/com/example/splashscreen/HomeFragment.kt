package com.example.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.splashscreen.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var  viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

       val view  = binding.root

        viewPager =view.findViewById(R.id.viewPager)

        //calling the function
        setupTabs()

        return  view
    }

    private fun setupTabs(){
        val adapter = TabsAdapter(activity?.supportFragmentManager!!)

        adapter.addFragments(FragmentMyFeed(), "My Feeds")
        adapter.addFragments(FragmentSaved(), "Saved")
        adapter.addFragments(FragmentSearch(), "Search")

        viewPager.adapter = adapter
        binding.tab.setupWithViewPager(viewPager)


    }


}