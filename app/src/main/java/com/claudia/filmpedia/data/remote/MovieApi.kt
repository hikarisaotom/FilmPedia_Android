package com.claudia.filmpedia.data.remote
import retrofit2.http.GET
import retrofit2.http.Query
interface MovieApi {

    @GET("movies")
    suspend fun getMovies(
        @Query("page") page:Int
    ):List<MovieDto>

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    }
}