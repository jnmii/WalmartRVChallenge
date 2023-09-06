package com.example.walmartrvchallenge.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartrvchallenge.R
import com.example.walmartrvchallenge.presentation.adapter.LocationAdapter
import com.example.walmartrvchallenge.databinding.ActivityMainBinding
import com.example.walmartrvchallenge.presentation.viewModel.LocationViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LocationViewModel
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(R.id.locationRv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        adapter = LocationAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.countries.observe(this) { countries ->
            adapter.updateData(countries)
        }
    }
}


