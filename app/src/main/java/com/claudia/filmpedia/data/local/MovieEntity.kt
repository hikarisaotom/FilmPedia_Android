package com.claudia.filmpedia.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val rate: Double,
    val year: Int,
    val duration: Int,
    val imageUrl: String,
    val genre: String,
)