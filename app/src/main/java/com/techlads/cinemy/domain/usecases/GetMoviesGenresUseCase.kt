package com.techlads.cinemy.domain.usecases

import com.techlads.cinemy.domain.model.GenresResponse
import com.techlads.cinemy.domain.repository.GenresRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesGenresUseCase @Inject constructor(
    private val repository: GenresRepository
) {
    fun invoke(): Flow<GenresResponse> = flow {
        repository.getMovieGenres()
    }
}