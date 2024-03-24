package com.claudia.filmpedia.data.local

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.claudia.filmpedia.data.mappers.toMovieEntity
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

            val movies = movieApi.getMovies(
                page = loadKey
            )

            movieDb.withTransaction {
                if(loadType == LoadType.REFRESH){
                    movieDb.dao.clearAll()
                }
                val movieEntities = movies.map {  it.toMovieEntity()}
                movieDb.dao.upsertAll(movieEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = movies.isEmpty()
            )
        }catch (e:IOException){
            MediatorResult.Error(e)
        }catch (e:HttpException){
            MediatorResult.Error(e)
        }
    }
}