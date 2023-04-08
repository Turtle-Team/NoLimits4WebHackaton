package com.lyadsky.nolimits4webapp.features.profile.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface ProfileViewModel : KmpViewModel, SubScreenViewModel {
    fun onSettingsClick()
}

class ProfileViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), ProfileViewModel {

    override fun onSettingsClick() {
        navigator.navigateToSettings()
    }
}


