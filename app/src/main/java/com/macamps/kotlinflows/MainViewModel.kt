package com.macamps.kotlinflows

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MainViewModel () : ViewModel() {
    private val mutableState = MutableStateFlow("")
    val stateFlow: StateFlow<String> = mutableState
}