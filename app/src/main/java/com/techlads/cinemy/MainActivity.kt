package com.techlads.cinemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.techlads.cinemy.navigation.AppNavigation
import com.techlads.cinemy.presentation.screens.home.HomeScreen
import com.techlads.cinemy.presentation.screens.splash.SplashScreen
import com.techlads.cinemy.ui.theme.CinemyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //HomeScreen()
                    //SplashScreen()
                    val navController = rememberAnimatedNavController()
                    CinemyThemeHandler(navController = navController)
                }
            }
        }
    }
}

@Composable
fun CinemyThemeHandler(navController: NavHostController) {
    CinemyTheme {
        AppNavigation(navController = navController)
    }
}
