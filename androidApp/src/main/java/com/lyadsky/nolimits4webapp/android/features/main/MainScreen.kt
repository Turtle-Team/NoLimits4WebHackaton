package com.lyadsky.nolimits4webapp.android.features.main

import androidx.compose.runtime.Composable
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.main.layouts.MainList
import com.lyadsky.nolimits4webapp.features.main.viewModel.MainViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

//TODO ViewModel

@Composable
fun MainScreen(
    viewModel: ViewModelWrapper<MainViewModel> = getViewModel(named("MainViewModel"))
) {
    MainList(viewModel)
}
