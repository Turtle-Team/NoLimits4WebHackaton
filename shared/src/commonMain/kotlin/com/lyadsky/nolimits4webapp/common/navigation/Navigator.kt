package com.lyadsky.nolimits4webapp.common.navigation

enum class ScreenRoute {
    Main,
    Profile,
    Welcome,
    Auth,
    Register
}

interface Navigator {
    fun navigateBack()
    fun navigateToMain()
    fun navigateToWelcome()
    fun navigateToAuth()
    fun navigateToRegister()
    fun navigateToProfile()
}
