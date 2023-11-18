package com.turkoglu.moviecompose.presentation.movies

import com.turkoglu.moviecompose.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error  : String = "",
    val search : String = "Star Wars"
    )
