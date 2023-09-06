package com.example.walmartrvchallenge.presentation.viewModel

import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.walmartrvchallenge.di.DependencyProvider
import com.example.walmartrvchallenge.presentation.model.Country
import com.example.walmartrvchallenge.data.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel : ViewModel() {

    private val apiService: ApiService = DependencyProvider.provideApiService()

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        val call = apiService.getCountries()
        call.enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {

                    _countries.value = response.body()
                } else {
                    handleErrorResponse(response)
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                handleNetworkFailure(t)
            }
        })
    }

    private fun handleErrorResponse(response: Response<List<Country>>) {
        val errorBody = response.errorBody()?.string() ?: "Unknown error"
        val errorMessage = "Error fetching data: $errorBody"
        logError(errorMessage)
        _error.value = errorMessage
    }

    private fun handleNetworkFailure(exception: Throwable) {
        val errorMessage = "Network request failed: ${exception.message ?: "Unknown error"}"
        logError(errorMessage)
        _error.value = errorMessage
    }

    private fun logError(errorMessage: String) {
        Log.e("LocationViewModel", errorMessage)
    }
    private fun showToast(message: String) {


    }
}


