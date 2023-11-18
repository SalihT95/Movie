package com.turkoglu.moviecompose.domain.use_case.get_movie_detail

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.turkoglu.moviecompose.data.remote.dto.toMovieDetail
import com.turkoglu.moviecompose.data.remote.dto.toMovieList
import com.turkoglu.moviecompose.domain.model.Movie
import com.turkoglu.moviecompose.domain.model.MovieDetail
import com.turkoglu.moviecompose.domain.repository.MovieRepository
import com.turkoglu.moviecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun executeGetMovieDetails(imdbId:String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e : IOException){
            emit(Resource.Error(message = "No internet connection"))
        }catch (e : HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }

    }

}