package com.turkoglu.moviecompose.data.dependencyinjection

import com.turkoglu.moviecompose.data.remote.MovieAPI
import com.turkoglu.moviecompose.data.repository.MovieRepositoryImpl
import com.turkoglu.moviecompose.domain.repository.MovieRepository
import com.turkoglu.moviecompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api : MovieAPI): MovieRepository{
        return MovieRepositoryImpl(api)
    }

}