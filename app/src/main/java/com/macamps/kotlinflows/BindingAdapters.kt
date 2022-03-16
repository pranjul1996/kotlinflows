package com.macamps.kotlinflows

import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.macamps.kotlinflows.data.Users

class BindingAdapters {

    companion object {
        var isLastPage = false
        var isRefreshing = false
        var scrollingPage = 1
        var limitValue = "10"
//        val linearLayoutManager =
//            LinearLayoutManager(ManvikApp.instance, LinearLayoutManager.VERTICAL, false)

        @BindingAdapter("references")
        @JvmStatic
        fun RecyclerView.bindRecyclerView(data: ArrayList<Users>?) {
            val referencesAdapter = UsersAdapter()
            this.apply {
                adapter = referencesAdapter
            }
            data.let { referencesAdapter.addItems(it) }
        }

        @BindingAdapter("onColorChanged")
        @JvmStatic
        fun AppCompatTextView.onColorChange(status:String) {

            when(status){
                "active"-> this.setTextColor(ContextCompat.getColor(context,R.color.green))
                "inactive"-> this.setTextColor(ContextCompat.getColor(context,R.color.red))
            }
        }
    }

}