package com.kocci.disastertracker.domain.reactive

sealed class Async<out T> {
    class Error(val message: String) : Async<Nothing>()
    class Success<T>(val data: T) : Async<T>()
    object Loading : Async<Nothing>()
}