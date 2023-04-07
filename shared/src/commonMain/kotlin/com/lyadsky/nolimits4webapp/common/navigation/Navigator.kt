package com.lyadsky.nolimits4webapp.common.navigation

enum class ScreenRoute {
    Main,
    Profile,
    Welcome,
    Auth,
    Register,
    InfoUser,
    Catalog
}

interface Navigator {
    fun navigateBack()
    fun navigateToMain()
    fun navigateToWelcome()
    fun navigateToAuth()
    fun navigateToRegister()
    fun navigateToProfile()
    fun navigateToInfoUser()
    fun navigateToCatalog()
}
