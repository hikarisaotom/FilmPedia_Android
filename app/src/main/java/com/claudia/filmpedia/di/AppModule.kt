package com.claudia.filmpedia.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.claudia.filmpedia.data.local.MovieDatabase
import com.claudia.filmpedia.data.local.MovieEntity
import com.claudia.filmpedia.data.local.MovieRemoteMediator
import com.claudia.filmpedia.data.local.NowPlayingEntity
import com.claudia.filmpedia.data.local.NowPlayingRemoteMediator
import com.claudia.filmpedia.data.local.TopRatedEntity
import com.claudia.filmpedia.data.local.TopRatedRemoteMediator
import com.claudia.filmpedia.data.local.UpcomingEntity
import com.claudia.filmpedia.data.local.UpcomingRemoteMediator
import com.claudia.filmpedia.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context:Context):MovieDatabase{
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movies.db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideMovieApi():MovieApi{
        return Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create()
    }

    @Provides
    @Singleton
    fun provideMoviePager(movieDb:MovieDatabase, movieApi:MovieApi):Pager<Int,MovieEntity>{
        return Pager(
            config = PagingConfig(pageSize = 1),
            remoteMediator = MovieRemoteMediator(movieDb,movieApi),
            pagingSourceFactory = {
                movieDb.dao.pagingSource()
            }
        )
    }
    @Provides
    @Singleton
    fun provideUpcomingPager(movieDb:MovieDatabase, movieApi:MovieApi):Pager<Int,UpcomingEntity>{
      return Pager(
          config = PagingConfig(pageSize = 1),
          remoteMediator = UpcomingRemoteMediator(movieDb,movieApi),
          pagingSourceFactory = {
              movieDb.dao.pagingUpcomingSource()
          }
      )
    }

    @Provides
    @Singleton
    fun provideTopRatedPager(movieDb:MovieDatabase, movieApi:MovieApi):Pager<Int,TopRatedEntity>{
        return Pager(
            config = PagingConfig(pageSize = 1),
            remoteMediator = TopRatedRemoteMediator(movieDb,movieApi),
            pagingSourceFactory = {
                movieDb.dao.pagingTopRatedSource()
            }
        )
    }

    @Provides
    @Singleton
    fun NowplayingPager(movieDb:MovieDatabase, movieApi:MovieApi):Pager<Int,NowPlayingEntity>{
        return Pager(
            config = PagingConfig(pageSize = 1),
            remoteMediator = NowPlayingRemoteMediator(movieDb,movieApi),
            pagingSourceFactory = {
                movieDb.dao.pagingNowPlayingSource()
            }
        )
    }
}