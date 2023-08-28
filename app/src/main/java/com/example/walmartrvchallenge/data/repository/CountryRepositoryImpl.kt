package com.example.walmartrvchallenge.data.repository

import android.util.Log
import com.example.walmartrvchallenge.data.local.CountriesDao
import com.example.walmartrvchallenge.data.network.ApiService
import com.example.walmartrvchallenge.domain.model.Country
import retrofit2.Call

class RepositoryImpl(private val apiService: ApiService) : CountryRepository {
    override suspend fun getCountries(): Call<List<Country>> {
        try {
            return apiService.getCountries()
        } catch (exception: Exception) {
            Log.e("RepositoryImpl",exception.toString())
            throw exception
        }
    }



}
