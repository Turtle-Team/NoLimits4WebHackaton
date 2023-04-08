package com.lyadsky.nolimits4webapp.common.navigation

enum class ScreenRoute {
    Main,
    Profile,
    Auth,
    Register,
    InfoUser,
    Catalog,
    Settings,
    Alphabet,
    Logic,
    Shapes,
    Mathematic,
    Helicopter,
    Numbers
}

interface Navigator {
    fun navigateBack()
    fun navigateToMain(clearBackStack: Boolean = false)
    fun navigateToAuth()
    fun navigateToRegister()
    fun navigateToProfile()
    fun navigateToCatalog()
    fun navigateToSettings()
    fun navigateToAlphabet()
    fun navigateToLogic()
    fun navigateToShapes()
    fun navigateToMathematic()
    fun navigateToHelicGame()
    fun navigateToNumbers()

    fun register()
    fun signOut()
}
