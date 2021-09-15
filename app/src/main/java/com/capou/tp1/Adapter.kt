package com.capou.tp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.capou.tp1.databinding.CustumnViewBinding
import com.capou.tp1.databinding.ItemCustomRecyclerFooterBinding
import com.capou.tp1.databinding.ItemCustomRecyclerHeaderBinding
import com.capou.tp1.model.MyObjectForRecyclerView
import com.capou.tp1.model.UserData
import com.capou.tp1.model.UserDataFooter
import com.capou.tp1.model.UserDataHeader

private val diffItemUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {

    override fun areItemsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
}


class Adapter(private val onItemClick: (quoteUi: UserData, view: View) -> Unit,) : ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(diffItemUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {

            MyItemType.ROW.type -> {
                AndroidVersionViewHolder(
                    CustumnViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),onItemClick
                )

            }


            MyItemType.HEADER.type -> {
                AndroidVersionHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            }

            MyItemType.FOOTER.type -> {
                AndroidVersionFooterViewHolder(
                    ItemCustomRecyclerFooterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            }


            else -> throw RuntimeException("Wrong view type received $viewType")
        }


override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //holder.bind(getItem(position))
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as AndroidVersionViewHolder).bind(getItem(position) as UserData)


            MyItemType.HEADER.type -> (holder as AndroidVersionHeaderViewHolder).bind(getItem(position) as UserDataHeader)

            MyItemType.FOOTER.type -> (holder as AndroidVersionFooterViewHolder).bind(getItem(position) as UserDataFooter)

            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is UserData -> MyItemType.ROW.type
            is UserDataHeader -> MyItemType.HEADER.type
            is UserDataFooter -> MyItemType.FOOTER.type
        }

}

class AndroidVersionHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataHeaderSample: UserDataHeader) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
    }


}

    class AndroidVersionFooterViewHolder(
        private val binding: ItemCustomRecyclerFooterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataFooter: UserDataFooter) {
            binding.itemRecyclerViewFooter.text = dataFooter.footer
        }


    }



class AndroidVersionViewHolder(
    private val binding: CustumnViewBinding,
    onItemClick: (objectDataSample: UserData, view: View) -> Unit
) : RecyclerView.ViewHolder(binding.root) {



    private lateinit var ui: UserData


    init {
        binding.root.setOnClickListener {
            onItemClick(ui, itemView)
        }
    }


    fun bind(objectDataSample: UserData) {
        ui = objectDataSample
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



    enum class MyItemType(val type: Int) {
        ROW(0),
        HEADER(1),
        FOOTER(2)
    }
}