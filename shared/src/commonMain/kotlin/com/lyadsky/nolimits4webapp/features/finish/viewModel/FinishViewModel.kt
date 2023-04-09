package com.lyadsky.nolimits4webapp.features.finish.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.data.AppDatabaseRepostitory
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

interface FinishViewModel : KmpViewModel, SubScreenViewModel {
    fun onNextClick()
}

class FinishViewModelImpl(
    override val navigator: Navigator,
    private val db: AppDatabaseRepostitory
) : KoinComponent, KmpViewModelImpl(), FinishViewModel {

    override fun onNextClick() {

        jobs.add(scope.launch {
            db.addLevel()
        })

        navigator.navigateToCatalog()
    }
}
