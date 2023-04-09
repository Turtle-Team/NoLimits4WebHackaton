package com.lyadsky.nolimits4webapp.features.settings.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface SettingsViewModel : KmpViewModel, SubScreenViewModel {
    fun onBackClick()

    fun onExitAccount()
}

class SettingsViewModelImpl(
    override val navigator: Navigator,
    private val userDataManager: UserDataManager
) : KoinComponent, KmpViewModelImpl(), SettingsViewModel {


    override fun onBackClick() {
        navigator.navigateToProfile()
    }

    override fun onExitAccount() {
        navigator.signOut()
        userDataManager.clearData()
    }
}


