package com.lyadsky.nolimits4webapp.android.features.register

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.infoUser.InfoUserScreen
import com.lyadsky.nolimits4webapp.android.features.register.layouts.HobbiesScreen
import com.lyadsky.nolimits4webapp.android.features.register.layouts.StartScreen
import com.lyadsky.nolimits4webapp.android.features.views.bars.StageBar
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun RegisterScreens(
    viewModelWrapper: ViewModelWrapper<RegisterViewModel> =
        getViewModel(named("RegisterViewModel"))
) {

    val state = viewModelWrapper.viewModel.state.collectAsState()

    BackHandler {
        viewModelWrapper.viewModel.onBackAction()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StageBar(Modifier.padding(top = 50.dp),number = state.value.stage, 3)
        when (state.value.stage) {
            1 -> StartScreen { viewModelWrapper.viewModel.onNextClick() }
            2 -> InfoUserScreen(viewModelWrapper)
            3 -> HobbiesScreen(viewModelWrapper)
            else -> {}
        }
    }
}
