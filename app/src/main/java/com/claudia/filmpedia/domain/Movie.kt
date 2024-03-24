package com.claudia.filmpedia.domain

data class Movie(
    val id:Int,
    val title: String,
    val rate: Double,
    val year: Int,
    val duration: Int,
    val imageUrl:String,
    val genre:String,
    val overwiew:String,
    val videoKey:String,
)