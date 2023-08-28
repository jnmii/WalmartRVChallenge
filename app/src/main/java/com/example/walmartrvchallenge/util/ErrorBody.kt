package com.example.walmartrvchallenge.util

sealed class ErrorBody{
    data class StringResource(val id: Int): ErrorBody()
    data class Message(val msg: String): ErrorBody()
}