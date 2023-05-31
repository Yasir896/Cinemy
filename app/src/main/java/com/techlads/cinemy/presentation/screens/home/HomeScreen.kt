package com.techlads.cinemy.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.techlads.cinemy.presentation.screens.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.getNowPlayingMovies()
    }

    val nowPlayingMovies = viewModel.moviesResponseState.value.data?.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        if (nowPlayingMovies != null) {
            items(nowPlayingMovies.itemCount) { index ->
                nowPlayingMovies[index]?.title?.let {

                    Text( modifier = Modifier.padding(),
                        text = it
                    )
                }
            }
        }
    }
}