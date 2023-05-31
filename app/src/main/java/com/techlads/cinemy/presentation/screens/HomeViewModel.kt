package com.techlads.cinemy.presentation.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import com.techlads.cinemy.domain.model.HomeScreenState
import com.techlads.cinemy.domain.usecases.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: GetNowPlayingMoviesUseCase) :
    ViewModel() {

        private val _moviesResponseState = mutableStateOf(HomeScreenState())
        val moviesResponseState: State<HomeScreenState> = _moviesResponseState

        fun getNowPlayingMovies() {
            viewModelScope.launch {
                _moviesResponseState.value = HomeScreenState(
                    data = useCase.invoke().map { pagingData ->
                        pagingData.filter {
                            it.id != 0
                        }
                    }.cachedIn(viewModelScope)
                )
            }
        }
}