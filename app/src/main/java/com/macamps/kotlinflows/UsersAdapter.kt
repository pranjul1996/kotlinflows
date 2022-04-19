package com.macamps.kotlinflows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.macamps.kotlinflows.databinding.AdViewBinding
import com.macamps.kotlinflows.databinding.UsersItemListBinding
import com.macamps.kotlinflows.model.Users
import kotlin.random.Random


const val AD_VIEW = 0
const val CONTENT_VIEW = 1


class UsersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemsList: ArrayList<Users>? = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == AD_VIEW) {
            ADViewHolder(AdViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else ViewHolder(
            UsersItemListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemViewType(position: Int) =
        if (position % 6 == 0) AD_VIEW else CONTENT_VIEW

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> itemsList?.let { holder.bind(it[position]) }
            is ADViewHolder -> holder.showAdView()
        }
    }

    class ADViewHolder(var binding: AdViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showAdView() {
            val adView = AdView(binding.root.context)
            adView.adSize = AdSize.BANNER
            adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
            val adRequest = AdRequest.Builder().build()
            binding.adView.loadAd(adRequest)
        }
    }

    class ViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(users: Users) {
            binding.setVariable(BR.user, users)
        }
    }

    fun addItems(newList: ArrayList<Users>?) {
//        if (itemList == null) itemsList = ArrayList()

        val diffCallback = DiffCallback(itemsList!!, newList!!)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        itemsList!!.clear()
        newList.let {
            for (i in newList.indices) {
                val item: Users = newList[i]
                if (!itemsList!!.contains(item)) itemsList!!.add(item)
            }
        }
        diffResult.dispatchUpdatesTo(this)
//        notifyDataSetChanged()
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount() = itemsList?.size ?: 0

    //    private class DiffCallback : DiffUtil.ItemCallback<Users>() {
//
//        override fun areItemsTheSame(oldItem: Users, newItem: Users) =
//            oldItem.hashCode() == newItem.hashCode()
//
//        override fun areContentsTheSame(oldItem: Users, newItem: Users) =
//            oldItem == newItem
//    }
    class DiffCallback(private val oldList: List<Users>, private val newList: List<Users>) :
        DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }

        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldCourse: Int, newPosition: Int): Boolean {
            val (_, value, gender) = oldList[oldCourse]
            val (_, value1, name1) = newList[newPosition]
            return gender == name1 && value == value1
        }

    }
}