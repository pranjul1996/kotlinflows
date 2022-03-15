package com.macamps.kotlinflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.macamps.kotlinflows.data.Users
import com.macamps.kotlinflows.di.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    private val mutableState = MutableStateFlow<ArrayList<Users>>(arrayListOf())
    private val error = MutableStateFlow("")
    private val isLoading = MutableStateFlow(false)
    val stateFlow: StateFlow<ArrayList<Users>> = mutableState

    fun getUsers() {
        viewModelScope.launch {
            repository.getUsers().collect { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        response.data?.let { mutableState.value = it
                        mutableState.emit(it)}

                        isLoading.emit(false)
                    }
                    is NetworkResult.Error -> {
                        response.message?.let {
                            error.value = it
                        }
                        isLoading.emit(false)
                        // show error message
                    }
                    is NetworkResult.Loading -> {
                        isLoading.emit(true)
                        // show a progress bar
                    }
                }
            }
        }
    }

}