package com.lyadsky.nolimits4webapp.common.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator

interface SubScreenViewModel {
    val navigator: Navigator

    fun onBackButtonClick() {
        navigator.navigateBack()
    }
}
