package com.claudia.filmpedia.data.mappers

import com.claudia.filmpedia.data.local.MovieEntity
import com.claudia.filmpedia.data.local.NowPlayingEntity
import com.claudia.filmpedia.data.local.TopRatedEntity
import com.claudia.filmpedia.data.local.UpcomingEntity
import com.claudia.filmpedia.data.remote.MovieDto
import com.claudia.filmpedia.domain.Movie

fun MovieDto.toMovieEntity():MovieEntity{
    return MovieEntity(
        id = id,
        title = title,
        rate = popularity,
        year=2019,
        duration=0,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview

    )
}

fun MovieDto.toNowPlayingEntity():NowPlayingEntity{
    return NowPlayingEntity(
        id = id,
        title = title,
        rate = popularity,
        year=2019,
        duration=0,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview
    )
}

fun MovieDto.toUpcomingEntity():UpcomingEntity{
    return UpcomingEntity(
        id = id,
        title = title,
        rate = popularity,
        year=2019,
        duration=0,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview,
    )
}

fun MovieDto.toTopRatedEntity():TopRatedEntity{
    return TopRatedEntity(
        id = id,
        title = title,
        rate = popularity,
        year=2019,
        duration=0,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview
    )
}

fun NowPlayingEntity.toMovie():Movie{
    return Movie(
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew
    )
}

fun UpcomingEntity.toMovie():Movie{
    return Movie(
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew
    )
}


fun TopRatedEntity.toMovie():Movie{
    return Movie(
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew
    )
}

fun MovieEntity.toMovie():Movie{
    return Movie(
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew
    )
}