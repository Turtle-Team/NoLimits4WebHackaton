package com.lyadsky.nolimits4webapp.features.mainNavigation.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.navigation.ScreenRoute
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import org.koin.core.component.KoinComponent

interface MainNavigationViewModel : KmpViewModel {
    fun onBottomBarButtonClicked(route: ScreenRoute)
}

class MainNavigationViewModelImpl(
    private val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), MainNavigationViewModel {
    override fun onBottomBarButtonClicked(route: ScreenRoute) {
        when (route) {
            ScreenRoute.Main -> navigator.navigateToMain()
            ScreenRoute.Profile -> navigator.navigateToProfile()
            ScreenRoute.Auth -> navigator.navigateToAuth()
            ScreenRoute.Register -> navigator.navigateToRegister()
            ScreenRoute.Catalog -> navigator.navigateToCatalog()
            ScreenRoute.Alphabet -> navigator.navigateToAlphabet()
            ScreenRoute.Shapes -> navigator.navigateToShapes()
            else -> {}
        }
    }
}
