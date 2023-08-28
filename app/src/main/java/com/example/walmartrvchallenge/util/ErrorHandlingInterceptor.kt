package com.example.walmartrvchallenge.util

import okhttp3.Interceptor
import okhttp3.Response

class ErrorHandlingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (!response.isSuccessful) {
            // Handle the error response globally
            val errorBody = response.body()?.string() ?: "Unknown error"
            val errorMessage = "Error fetching data: $errorBody"
            // Handle the error message or notify the user
            // You can log the error or use any other error handling mechanism here
        }

        return response
    }
}
