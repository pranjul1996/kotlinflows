package com.macamps.kotlinflows

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.macamps.kotlinflows.base.App


object Utils {



    fun getConnectionType(context: Context = App.instance): Int {
        var result = 0 // Returns connection type. 0: none; 1: mobile data; 2: wifi; 3: vpn
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        cm?.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                if (hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    result = 2
                } else if (hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    result = 1
                } else if (hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    result = 3
                }
            }
        }
        return result
    }

    // region deprecated code (Network Connection)
    //     fun isNetworkConnected(): Boolean {
    //        val cm = App.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    //        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    //    }
    // endregion

}