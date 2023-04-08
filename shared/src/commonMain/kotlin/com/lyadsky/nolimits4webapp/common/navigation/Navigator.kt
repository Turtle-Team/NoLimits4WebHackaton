package com.lyadsky.nolimits4webapp.common.navigation

enum class ScreenRoute {
    Main,
    Profile,
    Welcome,
    Auth,
    Register,
    Catalog
}

interface Navigator {
    fun navigateBack()
    fun navigateToMain(clearBackStack: Boolean = false)
    fun navigateToWelcome()
    fun navigateToAuth()
    fun navigateToRegister()
    fun navigateToProfile()
    fun navigateToCatalog()
}
