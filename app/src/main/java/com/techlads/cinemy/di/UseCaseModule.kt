package com.techlads.cinemy.di

import com.techlads.cinemy.domain.repository.MoviesRepository
import com.techlads.cinemy.domain.usecases.GetNowPlayingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository): GetNowPlayingMoviesUseCase =
        GetNowPlayingMoviesUseCase(repository)
}