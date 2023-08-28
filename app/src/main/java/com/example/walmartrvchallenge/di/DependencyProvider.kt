package com.example.walmartrvchallenge.di

import android.app.Application
import com.example.walmartrvchallenge.data.network.ApiService
import com.example.walmartrvchallenge.data.network.RetrofitInstance

object DependencyProvider {
    private lateinit var apiService: ApiService

    fun initialize(application: Application) {
        apiService = RetrofitInstance.apiService
    }
    fun provideApiService(): ApiService {
        return apiService
    }
}
