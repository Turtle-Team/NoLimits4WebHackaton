package com.lyadsky.nolimits4webapp.common.navigation

enum class ScreenRoute {
    Main,
    Profile,
    Welcome,
    Auth,
    Register,
    InfoUser,
    Catalog,
    Settings,
    Alphabet,
    Logic,
    Shapes,
    Mathematic,
    Numbers
}

interface Navigator {
    fun navigateBack()
    fun navigateToMain(clearBackStack: Boolean = false)
    fun navigateToWelcome(clearBackStack: Boolean = false)
    fun navigateToAuth()
    fun navigateToRegister()
    fun navigateToProfile()
    fun navigateToCatalog()
    fun navigateToSettings()
    fun navigateToAlphabet()
    fun navigateToLogic()
    fun navigateToShapes()
    fun navigateToMathematic()
    fun navigateToNumbers()
}
