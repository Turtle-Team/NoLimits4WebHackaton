package com.lyadsky.nolimits4webapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.lyadsky.nolimits4webapp.android.navigation.AndroidNavigator
import com.lyadsky.nolimits4webapp.android.features.mainNavigation.MainNavigationScreen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val rootNavigation: AndroidNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO get color from values
        window.statusBarColor = Color(0xFF194362).toArgb()
        setContent {
            val navController = rememberNavController()
            rootNavigation.navController = navController
            MainNavigationScreen(navController)
        }
    }
}
