package com.lyadsky.nolimits4webapp.android.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.navigation.ScreenRoute

interface AndroidNavigator : Navigator {
    var navController: NavHostController?
}

class NavigatorImpl(
    override var navController: NavHostController? = null
) : AndroidNavigator {
    override fun navigateBack() {
        navController?.popBackStack()
    }

    override fun navigateToMain() {
        navigateToNavBarDestination(ScreenRoute.Main)
    }

    override fun navigateToWelcome() {
        navigateToNavBarDestination(ScreenRoute.Welcome)
    }

    override fun navigateToAuth() {
        navigateToNavBarDestination(ScreenRoute.Auth)
    }

    override fun navigateToRegister() {
        navigateToNavBarDestination(ScreenRoute.Register)
    }

    override fun navigateToProfile() {
        navigateToNavBarDestination(ScreenRoute.Profile)
    }

    override fun navigateToInfoUser() {
        navigateToNavBarDestination(ScreenRoute.InfoUser)
    }

    override fun navigateToCatalog() {
        navigateToNavBarDestination(ScreenRoute.Catalog)
    }

    override fun navigateToSettings() {
        navigateToNavBarDestination(ScreenRoute.Settings)
    }


    private fun navigateToNavBarDestination(root: ScreenRoute) {
        navController?.navigate(root.name) {
            popUpTo(navController!!.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
