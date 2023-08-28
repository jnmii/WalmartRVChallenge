package com.example.walmartrvchallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walmartrvchallenge.domain.model.Country

@Dao
interface CountriesDao {
    @Insert
    fun cacheCountries(data: List<Country>)

    @Query("DELETE FROM ${Country.tableName}")
    fun clearTable()

    @Query("SELECT * FROM ${Country.tableName}")
    suspend fun getAllCountries(): List<Country>
}