package com.capou.tp1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.capou.tp1.model.WeatherRoom


@Dao
interface WeatherDao
 {

    @Query("SELECT * FROM weather")
    fun selectAll() : LiveData<List<WeatherRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisRoom: WeatherRoom)


    @Query("DELETE FROM weather")
    fun deleteAll()
}
