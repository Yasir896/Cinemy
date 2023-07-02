package com.techlads.cinemy.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.techlads.cinemy.Constants
import com.techlads.cinemy.domain.model.Movie

@Composable
fun MovieItem(modifier: Modifier, movie: Movie) {
    Card(modifier = modifier
        .fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberImagePainter(
                    data = "${Constants.IMAGE_BASE_UR}/${movie.posterPath}",
                    /*builder = {
                        placeholder(R.drawable.ic_placeholder)
                        crossfade(true)
                    }*/
                ),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                contentDescription = "Movie Banner"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = movie.title)
        }
        
    }
}