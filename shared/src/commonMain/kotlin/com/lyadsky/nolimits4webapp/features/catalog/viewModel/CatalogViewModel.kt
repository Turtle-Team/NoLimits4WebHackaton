package com.lyadsky.nolimits4webapp.features.catalog.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface CatalogViewModel : KmpViewModel, SubScreenViewModel {
    fun onAlphabetClick()
    fun onLogicClick()
}

class CatalogViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), CatalogViewModel {

    override fun onAlphabetClick() {
        navigator.navigateToAlphabet()
    }

    override fun onLogicClick() {
        navigator.navigateToLogic()
    }
}
