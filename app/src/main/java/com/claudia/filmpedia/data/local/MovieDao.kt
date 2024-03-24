package com.claudia.filmpedia.data.local
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDao {

    @Upsert
    suspend fun upsertAll(movies: List<MovieEntity>)

    @Upsert
    suspend fun upsertUpcomingAll(movies: List<UpcomingEntity>)
    @Upsert
    suspend fun upsertNowPlayingAll(movies: List<NowPlayingEntity>)
    @Upsert
    suspend fun upsertTopRatedAll(movies: List<TopRatedEntity>)
    @Upsert
    suspend fun upsertWatchListAll(movies: List<WatchlistEntity>)


    @Query("SELECT * FROM movieentity")
    fun pagingSource(): PagingSource<Int, MovieEntity>

    @Query("SELECT * FROM upcomingentity")
    fun pagingUpcomingSource(): PagingSource<Int, UpcomingEntity>

    @Query("SELECT * FROM nowplayingentity")
    fun pagingNowPlayingSource(): PagingSource<Int, NowPlayingEntity>

    @Query("SELECT * FROM topratedentity")
    fun pagingTopRatedSource(): PagingSource<Int, TopRatedEntity>

    @Query("SELECT * FROM watchlistentity")
    fun pagingWatchlistSource(): PagingSource<Int, WatchlistEntity>



    @Query("DELETE FROM movieentity")
    suspend fun clearAll()

    @Query("DELETE FROM watchlistentity")
    suspend fun clearWatchlistAll()

    @Query("DELETE FROM nowplayingentity")
    suspend fun clearNowPlayingAll()

    @Query("DELETE FROM upcomingentity")
    suspend fun clearUpcomingAll()

    @Query("DELETE FROM topratedentity")
    suspend fun clearTopRatedAll()
}