package com.capou.tp1.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.capou.tp1.databinding.WeatherItemBinding
import com.capou.tp1.model.WeatherUi



val diffUtils = object : DiffUtil.ItemCallback<WeatherUi>() {
    override fun areItemsTheSame(oldItem: WeatherUi, newItem: WeatherUi): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: WeatherUi, newItem: WeatherUi): Boolean {
        return oldItem == newItem
    }
}


//Ohter

class WeatherViewHolder(
    val binding: WeatherItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: WeatherUi

    fun bind(weatherUi: WeatherUi) {
        ui = weatherUi
        /*Glide.with(itemView.context)
            .load(chuckNorrisUi.iconUrl)
            .into(binding.itemChuckNorrisIcon)*/

        binding.itemChuckNorrisQuote.text = weatherUi.title
    }
}


//Other

class WeatherAdapter : ListAdapter<WeatherUi, WeatherViewHolder>(diffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            WeatherItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

