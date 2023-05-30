package com.techlads.cinemy.domain.datasource

import com.techlads.cinemy.BuildConfig
import com.techlads.cinemy.domain.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int = 0,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("language") language: String = "en"
    ): MoviesResponse

}