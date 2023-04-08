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

    override fun navigateToMain(clearBackStack: Boolean) {
        navigateToNavBarDestination(ScreenRoute.Main, clearBackStack)
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

    override fun navigateToCatalog() {
        navigateToNavBarDestination(ScreenRoute.Catalog)
    }

    override fun navigateToSettings() {
        navigateToNavBarDestination(ScreenRoute.Settings)
    }

    override fun navigateToAlphabet() {
        navigateToNavBarDestination(ScreenRoute.Alphabet)
    }

    override fun navigateToLogic() {
        navigateToNavBarDestination(ScreenRoute.Logic)
    }

    override fun navigateToShapes() {
        navigateToNavBarDestination(ScreenRoute.Shapes)
    }

    override fun navigateToMathematic() {
        navigateToNavBarDestination(ScreenRoute.Mathematic)
    }

    override fun navigateToHelicGame() {
        navigateToNavBarDestination(ScreenRoute.Helicopter)
    }

    override fun register() {
        navController?.navigate(ScreenRoute.Main.name){
            popUpTo(0){
                saveState = false
                this.inclusive = true
            }
        }

    }

    override fun signOut() {
        navController?.navigate(ScreenRoute.Register.name){
            popUpTo(0){
                saveState = false
                this.inclusive = true
            }
        }    }

    override fun navigateToNumbers() {
        navigateToNavBarDestination(ScreenRoute.Numbers)
    }

    private fun navigateToNavBarDestination(root: ScreenRoute, clearBackStack: Boolean = false) {
        navController?.navigate(root.name) {
                popUpTo(navController!!.graph.findStartDestination().id) {
                    saveState = true
                }
            launchSingleTop = true
            restoreState = true
        }
    }
}
