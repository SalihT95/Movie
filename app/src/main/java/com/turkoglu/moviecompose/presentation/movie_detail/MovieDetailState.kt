package com.turkoglu.moviecompose.presentation.movie_detail

import com.turkoglu.moviecompose.domain.model.MovieDetail
import com.turkoglu.moviecompose.util.Resource

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie : MovieDetail?=null,
    val error : String = ""
)
