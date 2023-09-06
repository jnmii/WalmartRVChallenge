package com.example.walmartrvchallenge.data.network

import com.example.walmartrvchallenge.presentation.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("countries.json")
    fun getCountries(): Call<List<Country>>
}
