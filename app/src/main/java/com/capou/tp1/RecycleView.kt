package com.capou.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capou.tp1.databinding.ActivityMainBinding
import com.capou.tp1.databinding.ActivityRecycleViewBinding
import com.capou.tp1.model.MyObjectForRecyclerView
import com.capou.tp1.model.UserData
import com.capou.tp1.model.UserDataFooter
import com.capou.tp1.model.UserDataHeader

class RecycleView : AppCompatActivity() {

    private lateinit var binding: ActivityRecycleViewBinding
    private lateinit var mAdapter :Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //utiliser les dp

        mAdapter = Adapter() { item, view ->
            onItemClick(item, view)
        }


        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = mAdapter

        // Generate data and give it to adapter
        mAdapter.submitList(generateFakeData())

    }


    private fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()
        // Create data raw
        mutableListOf(
            UserData("Antoine", "1","m"),
            UserData("Marie", "2","f"),
            UserData("Joseph", "3","m"),
            UserData("Marine", "4","f"),
            UserData("Anne", "5","f"),
            UserData("Louise", "6","f"),
            UserData("John", "7","m"),
            UserData("Xavier", "8","m"),
            UserData("Paul", "9","m"),
        ).groupBy {
            // Split in 2 list, modulo and not
            it.gender == "f"
        }.forEach { (isModulo, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            var gender = "Male"
            if(isModulo){
                gender = "Female"
            }
            result.add(UserDataHeader("$gender"))
            result.addAll(items)
            result.add(UserDataFooter("Nbre de '${gender.lowercase()}' (${items.sumOf{ it.gender.length }})"))
        }
        return result
    }

    private fun onItemClick(objectDataSample: UserData, view : View) {
        Toast.makeText(this, "Clique sur ${objectDataSample.name}", Toast.LENGTH_LONG).show()
    }


}