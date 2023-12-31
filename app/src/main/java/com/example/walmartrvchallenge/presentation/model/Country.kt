package com.example.walmartrvchallenge.presentation.model

import androidx.room.Entity
import com.example.walmartrvchallenge.presentation.model.Country.Companion.tableName

@Entity(tableName = tableName)
data class Country(
    val capital: String,
    val code: String,
    val currency: Currency,
    val flag: String,
    val language: Language,
    val name: String,
    val region: String
){
    companion object {
        const val tableName = "countries"
    }
}