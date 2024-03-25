package com.claudia.filmpedia.data.mappers

import com.claudia.filmpedia.data.local.MovieEntity
import com.claudia.filmpedia.data.local.NowPlayingEntity
import com.claudia.filmpedia.data.local.TopRatedEntity
import com.claudia.filmpedia.data.local.UpcomingEntity
import com.claudia.filmpedia.data.local.WatchlistEntity
import com.claudia.filmpedia.data.remote.MovieDto
import com.claudia.filmpedia.data.remote.Trailer
import com.claudia.filmpedia.domain.Movie
import java.text.DecimalFormat

fun MovieDto.toMovieEntity(video:Trailer?):MovieEntity{
    return MovieEntity(
        id = id,
        title = title,
        rate = DecimalFormat("#.##").format(vote_average).toDouble(),
        year=release_date.take(4).toInt(),
        duration= vote_count,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview,
        videoKey = video?.key ?: ""

    )
}

fun MovieDto.toNowPlayingEntity(video: Trailer?):NowPlayingEntity{
    return NowPlayingEntity(
        id = id,
        title = title,
        rate = DecimalFormat("#.##").format(vote_average).toDouble(),
        year=release_date.take(4).toInt(),
        duration= vote_count,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview,
        videoKey = video?.key ?: ""
    )
}

fun MovieDto.toUpcomingEntity(video: Trailer?):UpcomingEntity{
    return UpcomingEntity(
        id = id,
        title = title,
        rate = DecimalFormat("#.##").format(vote_average).toDouble(),
        year=release_date.take(4).toInt(),
        duration= vote_count,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview,
        videoKey = video?.key ?: ""
    )
}

fun MovieDto.toTopRatedEntity(video:Trailer?):TopRatedEntity{
    return TopRatedEntity(
        id = id,
        title = title,
        rate = DecimalFormat("#.##").format(vote_average).toDouble(),
        year=release_date.take(4).toInt(),
        duration= vote_count,
        imageUrl = "https://image.tmdb.org/t/p/w500/"+poster_path ?: "",
        genre = title,
        overwiew = overview,
        videoKey = video?.key ?: ""
    )
}

fun NowPlayingEntity.toMovie():Movie{
    return Movie(
        id = id,
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew,
       videoKey = videoKey
    )
}

fun WatchlistEntity.toMovie():Movie{
    return Movie(
        id = id,
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew,
        videoKey = videoKey
    )
}

fun UpcomingEntity.toMovie():Movie{
    return Movie(
        id = id,
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew,
        videoKey = videoKey
    )
}


fun TopRatedEntity.toMovie():Movie{
    return Movie(
        id = id,
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew,
        videoKey = videoKey
    )
}

fun MovieEntity.toMovie():Movie{
    return Movie(
        id = id,
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew,
        videoKey = videoKey
    )
}


fun Movie.toWatchlistEntity():WatchlistEntity{
    return WatchlistEntity(
        id =id,
        title = title,
        rate = rate,
        year=year,
        duration=duration,
        imageUrl = imageUrl,
        genre = genre,
        overwiew = overwiew,
        videoKey = videoKey
    )
}