package com.lyadsky.nolimits4webapp.android.features.tasks.colors

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
import com.lyadsky.nolimits4webapp.android.features.tasks.colors.layouts.Color1TaskScreen
import com.lyadsky.nolimits4webapp.android.features.tasks.colors.layouts.Color2TaskScreen
import com.lyadsky.nolimits4webapp.android.features.tasks.colors.layouts.Color3TaskScreen
import com.lyadsky.nolimits4webapp.android.features.views.bars.StageBar
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun ColorScreen(
    viewModelWrapper: ViewModelWrapper<TaskViewModel> =
        getViewModel(named("TaskViewModel"))
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
        StageBar(Modifier.padding(top = 50.dp), number = state.value.stage, 3)
        when (state.value.stage) {
            1 -> Color1TaskScreen(viewModelWrapper)
            2 -> Color2TaskScreen(viewModelWrapper)
            3 -> Color3TaskScreen(viewModelWrapper)
            else -> {}
        }
    }
}
