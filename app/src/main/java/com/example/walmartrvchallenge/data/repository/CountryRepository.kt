package com.example.walmartrvchallenge.data.repository

import com.example.walmartrvchallenge.domain.model.Country
import retrofit2.Call

interface CountryRepository {
    suspend fun getCountries(): Call<List<Country>>?

}
