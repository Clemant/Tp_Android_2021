package com.capou.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capou.tp1.databinding.ActivityMainBinding
import com.capou.tp1.databinding.ActivityRecycleViewBinding
import com.capou.tp1.model.UserData

class RecycleView : AppCompatActivity() {

    private lateinit var binding: ActivityRecycleViewBinding
    private lateinit var mAdapter :Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //utiliser les dp

        mAdapter = Adapter()

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = mAdapter

        // Generate data and give it to adapter
        mAdapter.submitList(generateFakeData())

    }


    private fun generateFakeData(): ArrayList<UserData> {

        return arrayListOf(
            UserData("Antoine", "1","m"),
            UserData("Marie", "2","f"),
            UserData("Joseph", "3","m"),
            UserData("Marine", "4","f"),
            UserData("Anne", "5","f"),
            UserData("Louise", "6","f"),
            UserData("John", "7","m"),
            UserData("Xavier", "8","m"),
            UserData("Paul", "9","m"),

        )
    }
}