package com.macamps.kotlinflows

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.macamps.kotlinflows.databinding.ActivityMainBinding
import com.macamps.kotlinflows.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    val let:String? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        Log.e("TAG", "onCreate: ", )

        //get the KEY value from the meta-data in AndroidManifest
        val ai: ApplicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        val value = ai.metaData["keyValue"]
        val key = value.toString()




        viewModel.getUsers()

    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy: ", )
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("TAG", "onRestart: ", )

    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume: ", )

    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG", "onStart: ", )

    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause: ", )

    }
}