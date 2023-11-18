package com.turkoglu.moviecompose.domain.use_case.get_movies

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.gestures.rememberDraggableState
import com.turkoglu.moviecompose.data.remote.dto.toMovieList
import com.turkoglu.moviecompose.domain.model.Movie
import com.turkoglu.moviecompose.domain.repository.MovieRepository
import com.turkoglu.moviecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun executeGetMovies(search:String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search = search)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))

            }else{
                emit(Resource.Error(message = "No Movie Found!"))
            }


        }catch (e : IOException){
            emit(Resource.Error(message = "No internet connection"))
        }catch (e : HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }

    }

}