package com.capou.tp1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.capou.tp1.databinding.CustumnViewBinding
import com.capou.tp1.model.UserData

private val diffItemUtils = object : DiffUtil.ItemCallback<UserData>() {


    override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem == newItem
    }
}


class Adapter : ListAdapter<UserData, AndroidVersionViewHolder>(diffItemUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidVersionViewHolder {
        return AndroidVersionViewHolder(
            CustumnViewBinding.inflate(
                LayoutInflater.from(parent.context),parent, false)
        )
    }


    override fun onBindViewHolder(holder: AndroidVersionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class AndroidVersionViewHolder(
    private val binding: CustumnViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(objectDataSample: UserData) {
        if(objectDataSample.gender == "f"){
            binding.iconGender.setImageResource(R.drawable.female)
            binding.Gender.text = "Female"
        }
        else{
            binding.iconGender.setImageResource(R.drawable.male)
            binding.Gender.text = "Male"
        }

        binding.FirstName.text = objectDataSample.firstname
        binding.Name.text = objectDataSample.name

    }
}