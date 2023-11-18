package com.turkoglu.moviecompose.data.remote

import com.turkoglu.moviecompose.data.remote.dto.MovieDetailDto
import com.turkoglu.moviecompose.data.remote.dto.MoviesDto
import com.turkoglu.moviecompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
//https://www.omdbapi.com/?i=tt3896198&apikey=82f989e5

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = API_KEY
    ): MoviesDto

    @GET(".")
    suspend fun getMoviesDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto


}