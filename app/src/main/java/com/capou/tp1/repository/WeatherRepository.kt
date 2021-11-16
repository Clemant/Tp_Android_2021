package com.capou.tp1.repository

import androidx.lifecycle.LiveData
import com.capou.tp1.architecture.MyApplication
import com.capou.tp1.architecture.MyDataRoom
import com.capou.tp1.architecture.RetrofitBuilder
import com.capou.tp1.model.WeatherRetrofit
import com.capou.tp1.model.WeatherRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class WeatherRepository {
private val myWeatherDao = MyApplication.instance.mApplicationDatabase.weatherDao()

fun selectAllWeatherData(): LiveData<List<WeatherRoom>> {
    return myWeatherDao.selectAll()
}


private suspend fun insertWeatherData(weatherData: WeatherRoom) =
    withContext(Dispatchers.IO) {
        myWeatherDao.insert(weatherData)
    }


suspend fun deleteAllWeatherData() = withContext(Dispatchers.IO) {
    myWeatherDao.deleteAll()
}


suspend fun fetchData() {
    insertWeatherData(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
}
}

private fun WeatherRetrofit.toRoom(): WeatherRoom {
    return WeatherRoom(
        title = title,
        consolidated_weather = consolidated_weather
    )
}



