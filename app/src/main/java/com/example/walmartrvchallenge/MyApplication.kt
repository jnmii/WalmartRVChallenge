package com.example.walmartrvchallenge

import android.app.Application
import com.example.walmartrvchallenge.di.DependencyProvider

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DependencyProvider.initialize(this)


    }
}
