package com.capou.tp1.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.capou.tp1.dao.WeatherDao
import com.capou.tp1.model.WeatherRoom

@Database(
        entities = [
            WeatherRoom::class
        ],
        version = 2,
        exportSchema = false
    )
    abstract class  MyDataRoom : RoomDatabase() {

        abstract fun weatherDao() : WeatherDao
    }
