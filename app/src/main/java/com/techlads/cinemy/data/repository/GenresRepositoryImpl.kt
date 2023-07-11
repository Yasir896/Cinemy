package com.techlads.cinemy.data.repository

import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.datasource.MoviesApi
import com.techlads.cinemy.domain.model.GenresResponse
import com.techlads.cinemy.domain.repository.GenresRepository

class GenresRepositoryImpl(private val api: MoviesApi): GenresRepository {
    override suspend fun getMovieGenres() = api.getMovieGenres()
}