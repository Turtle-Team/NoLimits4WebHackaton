package com.lyadsky.nolimits4webapp.features.profile.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.user_data.User
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface ProfileViewModel : KmpViewModel, SubScreenViewModel {
    fun onSettingsClick()

    fun getUser(): User
}

//TODO сделать стейт

class ProfileViewModelImpl(
    override val navigator: Navigator,
    private val userDataManager: UserDataManager
) : KoinComponent, KmpViewModelImpl(), ProfileViewModel {

    override fun onSettingsClick() {
        navigator.navigateToSettings()
    }

    override fun getUser(): User = userDataManager.getUserData()
}


