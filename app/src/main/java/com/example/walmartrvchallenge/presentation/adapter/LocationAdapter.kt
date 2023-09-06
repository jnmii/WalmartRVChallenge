package com.example.walmartrvchallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartrvchallenge.R
import com.example.walmartrvchallenge.presentation.model.Country

class LocationAdapter(private var countries: List<Country>) : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.location_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(country: Country) {
            itemView.findViewById<TextView>(R.id.nametv).text = "${country.name}, ${country.region}"
//            itemView.findViewById<TextView>(R.id.regiontv).text = country.region
            itemView.findViewById<TextView>(R.id.captialtv).text = country.capital
            itemView.findViewById<TextView>(R.id.codetv).text = country.code

        }
    }
    fun updateData(newCountries: List<Country>?) {
        if (newCountries != null) {
            countries = newCountries
            notifyDataSetChanged()
        }
    }
}
