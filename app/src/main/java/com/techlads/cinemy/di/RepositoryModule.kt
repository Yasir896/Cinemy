package com.techlads.cinemy.di

import com.techlads.cinemy.data.repository.MoviesRepositoryImpl
import com.techlads.cinemy.domain.datasource.MoviesApi
import com.techlads.cinemy.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(api: MoviesApi): MoviesRepository = MoviesRepositoryImpl(api)
}