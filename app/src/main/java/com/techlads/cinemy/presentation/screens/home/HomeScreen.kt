package com.techlads.cinemy.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberImagePainter
import com.techlads.cinemy.Constants.IMAGE_BASE_UR
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
        .fillMaxWidth()
        .padding(5.dp)) {

        if (nowPlayingMovies != null) {
            if (nowPlayingMovies.loadState.append == LoadState.Loading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            } else {
                items(nowPlayingMovies.itemCount) { index ->
                    nowPlayingMovies[index]?.let {
                        MovieItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            movie = it
                        )
                    }
                }
            }
        }
    }
}