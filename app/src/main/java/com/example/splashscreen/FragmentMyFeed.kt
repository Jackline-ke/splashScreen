package com.example.splashscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.splashscreen.databinding.FragmentHomeBinding
import com.example.splashscreen.databinding.FragmentMyFeedBinding
import com.example.splashscreen.databinding.MyBeerRowBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "FragmentMyFeed"

class FragmentMyFeed : Fragment() {

    private lateinit var  binding: FragmentMyFeedBinding
    private val adapter by lazy { BeerAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentMyFeedBinding.inflate(inflater,container,false)
        val view = binding.root

        BeersApi.apiService.getBeers().enqueue(object: Callback<Beers>{
            override fun onFailure(call: Call<Beers>, t: Throwable) {

                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<Beers>, response: Response<Beers>) {
                Log.d(TAG, "onResponse: ${response.body()}")
                val myList = response.body()
                adapter.submitList(myList)
                binding.recyclerview.adapter = adapter
            }

        })
        return view
    }

}