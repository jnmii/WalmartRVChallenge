package com.example.walmartrvchallenge.data.local

import androidx.room.TypeConverter
import com.example.walmartrvchallenge.domain.model.Currency
import com.example.walmartrvchallenge.domain.model.Language
import com.google.gson.Gson

class RoomConverters {
    @TypeConverter
    fun currencyToJson(data: Currency) = Gson().toJson(data)

    @TypeConverter
    fun currencyFromJson(json: String) = Gson().fromJson(json, Currency::class.java)

    @TypeConverter
    fun languageToJson(data: Language) = Gson().toJson(data)

    @TypeConverter
    fun languageFromJson(json: String) = Gson().fromJson(json, Language::class.java)
}