package com.claudia.filmpedia.data.mappers

import com.claudia.filmpedia.data.local.MovieEntity
import com.claudia.filmpedia.data.remote.MovieDto
import com.claudia.filmpedia.domain.Movie

fun MovieDto.toMovieEntity():MovieEntity{
    return MovieEntity(
        id = 1,
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre
    )
}

fun MovieEntity.toMovie():Movie{
    return Movie(
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre
    )
}