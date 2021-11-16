package com.capou.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.capou.tp1.databinding.ActivityWeatherBinding
import com.capou.tp1.model.WeatherUi
import com.capou.tp1.view.WeatherAdapter
import com.capou.tp1.viewModel.WeatherViewModel

class Weather : AppCompatActivity() {

     private lateinit var viewModel: WeatherViewModel
     private lateinit var binding : ActivityWeatherBinding
     private val adapter : WeatherAdapter = WeatherAdapter()
     private val observer = Observer<List<WeatherUi>> {
        adapter.submitList(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]


        binding.chuckNorrisActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.chuckNorrisActivityRv.adapter = adapter


        binding.chuckNorrisActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }


        binding.chuckNorrisActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }
    override fun onStart() {
        super.onStart()
      //  viewModel.weatherLiveData.observe(this, observer)
    }


    override fun onStop() {
       // viewModel.weatherLiveData.removeObserver(observer)
        super.onStop()
    }

}