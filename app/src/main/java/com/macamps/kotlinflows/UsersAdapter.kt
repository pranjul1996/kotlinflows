package com.macamps.kotlinflows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.macamps.kotlinflows.model.Users
import com.macamps.kotlinflows.databinding.UsersItemListBinding

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    private var itemsList: ArrayList<Users>? = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        UsersItemListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemsList?.let { holder.bind(it[position]) }
    }

    class ViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(users: Users) {
            binding.setVariable(BR.user, users)
        }
    }

    fun addItems(itemList: ArrayList<Users>?) {
//        if (itemList == null) itemsList = ArrayList()
        itemList?.let {
            for (i in itemList.indices) {
                val item: Users = itemList[i]
                if (!itemsList!!.contains(item)) itemsList!!.add(item)
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount() = itemsList?.size ?: 0
}