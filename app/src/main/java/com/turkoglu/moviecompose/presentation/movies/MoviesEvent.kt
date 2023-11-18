package com.turkoglu.moviecompose.presentation.movies

sealed class MoviesEvent{
    data class Search (val searchString: String): MoviesEvent()
}
