package com.example.walmartrvchallenge.data.network




import com.example.walmartrvchallenge.util.ErrorHandlingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BaseUrl = ApiBaseUrl.API // Use the enum constant here

    // Create an OkHttpClient with the error handling interceptor
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ErrorHandlingInterceptor())
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // Set the custom OkHttpClient with the error handling interceptor
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

