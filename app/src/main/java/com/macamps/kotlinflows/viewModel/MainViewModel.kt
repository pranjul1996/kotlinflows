package com.macamps.kotlinflows.viewModel

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.macamps.kotlinflows.data.MainDbSource
import com.macamps.kotlinflows.base.NetworkResult
import com.macamps.kotlinflows.Utils.getConnectionType
import com.macamps.kotlinflows.model.Users
import com.macamps.kotlinflows.data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val mainDbSource: MainDbSource
) : ViewModel() {
    private val mutableState = MutableStateFlow<ArrayList<Users>>(arrayListOf())
    private val error = MutableStateFlow("")
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    val stateFlow: StateFlow<ArrayList<Users>> = mutableState

    fun getUsers() {
        viewModelScope.launch {
            _isLoading.emit(true)
            if (getConnectionType()==0) { // return from database
                repository.getUsersFromDb().collect {
                    if (it.isNotEmpty()) {
                        mutableState.emit(it as ArrayList<Users>)
                        _isLoading.emit(false)
                    }
                }
            } else // return from remote data
                repository.getUsers().collect { response ->
                    when (response) {
                        is NetworkResult.Success -> {
                            response.data?.let {
                                mainDbSource.insert(it)
                                mutableState.emit(it)
                            }

                            _isLoading.emit(false)
                        }
                        is NetworkResult.Error -> {
                            response.message?.let {
                                error.value = it
                            }
                            _isLoading.emit(false)
                            // show error message
                        }
                        is NetworkResult.Loading -> {
                            _isLoading.emit(true)
                            // show a progress bar
                        }
                    }
                }
        }
    }

}