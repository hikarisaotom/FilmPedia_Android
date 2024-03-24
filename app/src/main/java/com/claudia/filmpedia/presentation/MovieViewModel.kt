package com.claudia.filmpedia.presentation

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.claudia.filmpedia.data.local.MovieDatabase
import com.claudia.filmpedia.data.local.MovieEntity
import com.claudia.filmpedia.data.local.NowPlayingEntity
import com.claudia.filmpedia.data.local.TopRatedEntity
import com.claudia.filmpedia.data.local.UpcomingEntity
import com.claudia.filmpedia.data.local.WatchlistEntity
import com.claudia.filmpedia.data.mappers.toMovie
import com.claudia.filmpedia.domain.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MovieViewModel @Inject constructor(
    pager:Pager<Int,MovieEntity>,
    upcomingPager:Pager<Int,UpcomingEntity>,
    nowPlayingPager:Pager<Int,NowPlayingEntity>,
    topRatedPager:Pager<Int,TopRatedEntity>,
    watchListPager:Pager<Int,WatchlistEntity>,
    private val movieDb: MovieDatabase
):ViewModel(){
    private val _currentMovie = MutableStateFlow<Movie?>(null)
    val currentMovie = _currentMovie.asStateFlow()

    val moviePagingFlow = pager.
    flow.
    map { pagingData-> pagingData.map { it.toMovie() }}
        .cachedIn(viewModelScope)

    val upComingPagingFlow = upcomingPager.
    flow.
    map { pagingData-> pagingData.map { it.toMovie() }}
        .cachedIn(viewModelScope)

    val topRatedPagingFlow = topRatedPager.
    flow.
    map { pagingData-> pagingData.map { it.toMovie() }}
        .cachedIn(viewModelScope)

    val nowPlayingPagingFlow = nowPlayingPager.
    flow.
    map { pagingData-> pagingData.map { it.toMovie() }}
        .cachedIn(viewModelScope)
    var watchlistPagingFlow =  watchListPager. flow.
    map { pagingData-> pagingData.map { it.toMovie() }}
        .cachedIn(viewModelScope)

    fun selectMovie(movie: Movie) {
        _currentMovie.value = movie
    }

    fun clearCurrentMovie() {
        _currentMovie.value = null
    }

    private fun insertWatchlist(movie:Movie){
        viewModelScope.launch {
            val entry = WatchlistEntity(
                id = movie.id,
                title = movie.title,
                rate = movie.rate,
                year = movie.year,
                duration = movie.duration,
                imageUrl = movie.imageUrl,
                genre = movie.genre,
                overwiew = movie.overwiew,
                videoKey = movie.videoKey
            )
            movieDb.dao.insert(entry)
            loadWatchList()
        }
    }
    private fun getWatchlistPager(): Pager<Int, WatchlistEntity> {
        return Pager(
            config = PagingConfig(pageSize = 1),
            pagingSourceFactory = { movieDb.dao.pagingWatchlistSource() }
        )
    }
    private fun removeWatchList(movie:Movie){
            viewModelScope.launch {
                movieDb.dao.deleteById(movie.id)
                loadWatchList()
            }
    }
    fun toggleWatchList(movie:Movie, isInWatchList:Boolean){
        if(isInWatchList){
            removeWatchList(movie = movie)
        }else{
            insertWatchlist(movie = movie)
        }
    }

    private fun loadWatchList(){
        watchlistPagingFlow = getWatchlistPager().flow.map { pagingData ->
            pagingData.map { it.toMovie() }
        }.cachedIn(viewModelScope)
    }
}