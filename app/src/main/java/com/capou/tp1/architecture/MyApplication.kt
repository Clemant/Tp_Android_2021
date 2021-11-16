package com.capou.tp1.architecture

import android.app.Application
import androidx.room.Room

class MyApplication :Application() {


    companion object {
        lateinit var instance: MyApplication
    }


    val mApplicationDatabase: MyDataRoom by lazy {
        Room.databaseBuilder(
            applicationContext,
            MyDataRoom::class.java,
            "MyDatabaseName"
        ).fallbackToDestructiveMigration().build()
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
