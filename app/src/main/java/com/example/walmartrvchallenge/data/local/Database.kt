package com.example.walmartrvchallenge.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.walmartrvchallenge.domain.model.Country


@Database(entities = [Country::class], version = 1)
@TypeConverters(value = [RoomConverters::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun countriesDao(): CountriesDao

    companion object {
        private var instance: AppDatabase? = null
        const val dbName = "countries"

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    dbName
                ).build()
            }
            return instance as AppDatabase
        }
    }
}
