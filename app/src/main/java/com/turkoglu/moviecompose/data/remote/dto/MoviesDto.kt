package com.turkoglu.moviecompose.data.remote.dto

import com.turkoglu.moviecompose.domain.model.Movie

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDto.toMovieList() : List<Movie> {
    return Search.map{
        Movie(it.Poster , it.Title , it.Type , it.Year , it.imdbID) }
}