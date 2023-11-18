package com.turkoglu.moviecompose.domain.repository

import com.turkoglu.moviecompose.data.remote.dto.MovieDetailDto
import com.turkoglu.moviecompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String): MoviesDto
    suspend fun getMovieDDetail(imdbId:String): MovieDetailDto

}