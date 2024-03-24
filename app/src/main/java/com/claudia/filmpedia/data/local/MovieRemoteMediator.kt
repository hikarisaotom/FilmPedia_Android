package com.claudia.filmpedia.data.local

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.claudia.filmpedia.data.mappers.toMovieEntity
import com.claudia.filmpedia.data.mappers.toNowPlayingEntity
import com.claudia.filmpedia.data.mappers.toTopRatedEntity
import com.claudia.filmpedia.data.mappers.toUpcomingEntity
import com.claudia.filmpedia.data.remote.MovieApi
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MovieRemoteMediator (
    private val movieDb:MovieDatabase,
    private val movieApi: MovieApi,
        ):RemoteMediator<Int,MovieEntity>(){
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        return try{
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> MediatorResult.Success( endOfPaginationReached = true)
                LoadType.APPEND -> 1
                LoadType.PREPEND -> 1
            }
            val movies = movieApi.getPopularMovies(MovieApi.API_KEY).results

            movieDb.withTransaction {
                if(loadType == LoadType.REFRESH){
                    movieDb.dao.clearAll()
                }
                val movieEntities = movies.map {  it.toMovieEntity()}
                movieDb.dao.upsertAll(movieEntities)
            }

            MediatorResult.Success(
            endOfPaginationReached = true
            )
        }catch (e:IOException){
            MediatorResult.Error(e)
        }catch (e:HttpException){
            MediatorResult.Error(e)
        }
    }
}
@OptIn(ExperimentalPagingApi::class)
class UpcomingRemoteMediator (
    private val movieDb:MovieDatabase,
    private val movieApi: MovieApi,
):RemoteMediator<Int,UpcomingEntity>(){
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UpcomingEntity>
    ): MediatorResult {
        return try{
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> MediatorResult.Success( endOfPaginationReached = true)
                LoadType.APPEND -> 1
                LoadType.PREPEND -> 1
            }
            val upcoming = movieApi.getUpcomingMovies(MovieApi.API_KEY).results
            movieDb.withTransaction {
                if(loadType == LoadType.REFRESH){
                    movieDb.dao.clearUpcomingAll()
                }

                val upcomingEntities = upcoming.map {  it.toUpcomingEntity()}
                movieDb.dao.upsertUpcomingAll(upcomingEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = true
            )
        }catch (e:IOException){
            MediatorResult.Error(e)
        }catch (e:HttpException){
            MediatorResult.Error(e)
        }
    }
}



@OptIn(ExperimentalPagingApi::class)
class TopRatedRemoteMediator (
    private val movieDb:MovieDatabase,
    private val movieApi: MovieApi,
):RemoteMediator<Int,TopRatedEntity>(){
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TopRatedEntity>
    ): MediatorResult {
        return try{
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> MediatorResult.Success( endOfPaginationReached = true)
                LoadType.APPEND -> 1
                LoadType.PREPEND -> 1
            }
            val topRated = movieApi.getTopRatedMovies(MovieApi.API_KEY).results

            movieDb.withTransaction {
                if(loadType == LoadType.REFRESH){
                    movieDb.dao.clearTopRatedAll()
                }
                val topRatedEntities = topRated.map { it.toTopRatedEntity()}
                movieDb.dao.upsertTopRatedAll(topRatedEntities)
            }
            MediatorResult.Success(
                endOfPaginationReached = true
            )
        }catch (e:IOException){
            MediatorResult.Error(e)
        }catch (e:HttpException){
            MediatorResult.Error(e)
        }
    }
}


@OptIn(ExperimentalPagingApi::class)
class NowPlayingRemoteMediator (
    private val movieDb:MovieDatabase,
    private val movieApi: MovieApi,
):RemoteMediator<Int,NowPlayingEntity>(){
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, NowPlayingEntity>
    ): MediatorResult {
        return try{
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> MediatorResult.Success( endOfPaginationReached = true)
                LoadType.APPEND -> 1
                LoadType.PREPEND -> 1
            }
            val nowPlaying = movieApi.getNowPlayingMovies(MovieApi.API_KEY).results

            movieDb.withTransaction {
                if(loadType == LoadType.REFRESH){
                    movieDb.dao.clearNowPlayingAll()
                }
                val nowPlayingEntity = nowPlaying.map { it.toNowPlayingEntity() }
                movieDb.dao.upsertNowPlayingAll(nowPlayingEntity)
            }

            MediatorResult.Success(
                endOfPaginationReached = true
            )
        }catch (e:IOException){
            MediatorResult.Error(e)
        }catch (e:HttpException){
            MediatorResult.Error(e)
        }
    }
}
