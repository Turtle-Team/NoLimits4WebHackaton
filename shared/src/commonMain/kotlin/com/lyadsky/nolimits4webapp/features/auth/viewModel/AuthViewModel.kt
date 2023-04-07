package com.lyadsky.nolimits4webapp.features.auth.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface AuthViewModel : KmpViewModel, SubScreenViewModel {
    fun onAuthClick()
    fun onRegisterClick()
}

class AuthViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), AuthViewModel {

    override fun onAuthClick() {
        navigator.navigateToAuth()
    }

    override fun onRegisterClick() {
        navigator.navigateToRegister()
    }
}

