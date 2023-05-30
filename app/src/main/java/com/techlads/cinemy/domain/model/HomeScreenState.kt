package com.techlads.cinemy.domain.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

data class HomeScreenState(
    val data: Flow<PagingData<Movie>>? = null,
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String? = null
)