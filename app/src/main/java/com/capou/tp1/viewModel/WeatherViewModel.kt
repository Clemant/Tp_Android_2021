package com.capou.tp1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.capou.tp1.model.WeatherRoom
import com.capou.tp1.model.WeatherUi
import com.capou.tp1.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {


    private val weatherRepository: WeatherRepository by lazy { WeatherRepository() }

    var weatherLiveData: LiveData<List<WeatherUi>> =
        weatherRepository.selectAllWeatherData().map {
            it.toUi()
        }


    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.fetchData()
        }
    }


    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.deleteAllWeatherData()
        }
    }
}


private fun List<WeatherRoom>.toUi(): List<WeatherUi> {
    return asSequence().map {
        WeatherUi(
            title = it.title,
            consolidated_weather = it.consolidated_weather
        )
    }.toList()
}
