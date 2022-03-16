package com.macamps.kotlinflows

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService


object Utils {
     fun isNetworkConnected(): Boolean {
        val cm = App.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}