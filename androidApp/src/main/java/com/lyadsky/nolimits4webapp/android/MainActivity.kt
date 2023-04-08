package com.lyadsky.nolimits4webapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.lyadsky.nolimits4webapp.android.features.mainNavigation.MainNavigationScreen
import com.lyadsky.nolimits4webapp.android.navigation.AndroidNavigator
import com.lyadsky.nolimits4webapp.common.navigation.ScreenRoute
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val rootNavigation: AndroidNavigator by inject()
    private val userData: UserDataManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val startDestination = defineStartDestination()

        window.statusBarColor = Color.White.toArgb()

        setContent {
            val navController = rememberNavController()
            rootNavigation.navController = navController
            AppTheme() {
                MainNavigationScreen(navController, startDestination = startDestination)
            }
        }
    }

    private fun defineStartDestination(): ScreenRoute {
        val data = userData.getUserData()
        return if (data.isNotEmpty())
            ScreenRoute.Main
        else
            ScreenRoute.Welcome
    }
}
