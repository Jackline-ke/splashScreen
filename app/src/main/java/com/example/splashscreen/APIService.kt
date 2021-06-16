package com.example.splashscreen

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {

    @GET("beers")
    fun getBeers() : Call<Beers>
}
//object class
object BeersApi{
    private const val BASE_URL = "https://api.punkapi.com/v2/"

   private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiService by lazy {
        retrofit.create(APIService::class.java)
    }

}