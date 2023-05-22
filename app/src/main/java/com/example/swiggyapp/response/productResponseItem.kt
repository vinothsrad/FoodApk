package com.example.swiggyapp.response

data class productResponseItem(
    val description: String,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val rating: String
)