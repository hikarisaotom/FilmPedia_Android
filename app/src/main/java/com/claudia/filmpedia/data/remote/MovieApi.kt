package com.claudia.filmpedia.data.remote
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.moshi.MoshiConverterFactory
interface MovieApi {

    @GET("movies")
    suspend fun getMovies(
        @Query("page") page:Int
    ):List<MovieDto>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String
    ): Any

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): List<MovieDto>


    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String
    ): List<MovieDto>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String
    ): List<MovieDto>

     companion object {
         const val BASE_URL = "https://api.themoviedb.org/3/"
         const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3YTMwYzI0MzY2NWY4NTgyNWU4ZjdlNmFlMTk3MTFmYSIsInN1YiI6IjYwMTFmN2IzY2NkZTA0MDA0MTI4MGM2MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9vzxRCDXBckJ0NhWB30v-O85-E7Yd5MzrUEKnz4iDG8"
////         private val moshi = Moshi.Builder().build()
//         private val retrofit: Retrofit by lazy {
//             Retrofit.Builder()
//                 .baseUrl(BASE_URL)
////                 .addConverterFactory(MoshiConverterFactory.create(moshi))
//                 .build()
//         }
//
//         val movieApiService: MovieApi by lazy {
//             retrofit.create(MovieApi::class.java)
//         }

    }
}