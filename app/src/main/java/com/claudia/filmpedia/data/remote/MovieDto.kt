package com.claudia.filmpedia.data.remote

data class MovieDto (
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
        )

data class MovieResponse(
   val page: Int,
    val results: List<MovieDto>,
    val totalPages: Int,
   val totalResults: Int
)



data class MovieTrailers(
    val id: Int,
    val results: List<Trailer>
)

data class Trailer(
    val iso_639_1: String,
    val iso_3166_1: String,
    val name: String,
    val key: String,
    val site: String,
    val size: Int,
    val type: String,
    val official: Boolean,
    val published_at: String,
    val id: String
)
