package com.lyadsky.nolimits4webapp.android.features.mainNavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.auth.AuthScreen
import com.lyadsky.nolimits4webapp.android.features.catalog.CatalogScreen
import com.lyadsky.nolimits4webapp.android.features.main.MainScreen
import com.lyadsky.nolimits4webapp.android.features.profile.ProfileScreen
import com.lyadsky.nolimits4webapp.android.features.register.RegisterScreens
import com.lyadsky.nolimits4webapp.android.features.settings.SettingsScreen
import com.lyadsky.nolimits4webapp.android.features.tasks.alphabet.AlphabetScreen
import com.lyadsky.nolimits4webapp.android.features.welcome.WelcomeScreen
import com.lyadsky.nolimits4webapp.common.navigation.ScreenRoute
import com.lyadsky.nolimits4webapp.features.mainNavigation.viewModel.MainNavigationViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun MainNavigationScreen(
    navController: NavHostController = rememberNavController(),
    viewModelWrapper: ViewModelWrapper<MainNavigationViewModel> =
        getViewModel(qualifier = named("MainNavigationViewModel")),
    startDestination: ScreenRoute
) {
    val backStackState = navController.currentBackStackEntryAsState()
    val currentRoute = backStackState.value
        ?.destination?.route?.substringBefore("/") ?: startDestination

    DisposableEffect(key1 = viewModelWrapper) {
        viewModelWrapper.viewModel.onViewShown()
        onDispose { viewModelWrapper.viewModel.onViewHidden() }
    }
    Scaffold(
        bottomBar = {
            val isMainScreen = bottomNavigationItems.any { it.route.name == currentRoute }
            if (isMainScreen)
                BottomBar(ScreenRoute.valueOf(currentRoute.toString())) { route: ScreenRoute ->
                    viewModelWrapper.viewModel.onBottomBarButtonClicked(route)
                }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = ScreenRoute.Main.name) {
                MainScreen()
            }
            composable(route = ScreenRoute.Profile.name) {
                ProfileScreen()
            }
            composable(route = ScreenRoute.Auth.name) {
                AuthScreen()
            }
            composable(route = ScreenRoute.Register.name) {
                RegisterScreens()
            }
            composable(route = ScreenRoute.Welcome.name) {
                WelcomeScreen()
            }
            composable(route = ScreenRoute.Catalog.name) {
                CatalogScreen()
            }
            composable(route = ScreenRoute.Settings.name) {
                SettingsScreen()
            }
            composable(route = ScreenRoute.Alphabet.name) {
                AlphabetScreen()
            }
        }
    }
}
