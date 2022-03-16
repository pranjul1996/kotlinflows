package com.macamps.kotlinflows.base

sealed class State<out T: Any> {
    data class Success<out T: Any>(val data: T): State<T>()
    data class Error(val exception: Throwable): State<Nothing>()
    object Loading: State<Nothing>()

//    fun toData(): T? = if(this is Success) this.data else null
}