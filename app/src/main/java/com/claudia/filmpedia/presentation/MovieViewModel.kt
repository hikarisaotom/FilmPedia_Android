package com.claudia.filmpedia.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.claudia.filmpedia.data.local.MovieEntity
import com.claudia.filmpedia.data.local.NowPlayingEntity
import com.claudia.filmpedia.data.local.TopRatedEntity
import com.claudia.filmpedia.data.local.UpcomingEntity
import com.claudia.filmpedia.data.mappers.toMovie
import com.claudia.filmpedia.domain.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
@HiltViewModel
class MovieViewModel @Inject constructor(
    pager:Pager<Int,MovieEntity>,
    upcomingPager:Pager<Int,UpcomingEntity>,
    nowPlayingPager:Pager<Int,NowPlayingEntity>,
    topRatedPager:Pager<Int,TopRatedEntity>,
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

    fun selectMovie(movie: Movie) {
        _currentMovie.value = movie
    }

    fun clearCurrentMovie() {
        _currentMovie.value = null
    }
}