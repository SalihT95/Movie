package com.turkoglu.moviecompose.data.repository

import com.turkoglu.moviecompose.data.remote.MovieAPI
import com.turkoglu.moviecompose.data.remote.dto.MovieDetailDto
import com.turkoglu.moviecompose.data.remote.dto.MoviesDto
import com.turkoglu.moviecompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor( private val api : MovieAPI ): MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDDetail(imdbId: String): MovieDetailDto {
        return api.getMoviesDetail(imdbId = imdbId)
    }
}