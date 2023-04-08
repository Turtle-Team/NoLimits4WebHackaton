package com.lyadsky.nolimits4webapp.android.features.register.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel

@Composable
fun RegisterScreen(
    viewModelWrapper: ViewModelWrapper<RegisterViewModel>
) {

    val state = viewModelWrapper.viewModel.state.collectAsState()

    LazyColumn(
        Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 50.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically)
            ) {
                CommonEditText(
                    title = "Имя пользователя",
                    onValueChanged = {viewModelWrapper.viewModel.onNameChanged(it)},
                    textState = state.value.name
                )

                CommonEditText(
                    title = "Электронная почта",
                    onValueChanged = {viewModelWrapper.viewModel.onEmailChanged(it)},
                    textState = state.value.email
                )

                CommonEditText(
                    title = "Пароль",
                    onValueChanged = {viewModelWrapper.viewModel.onPasswordChanged(it)},
                    textState = state.value.password
                )
            }
        }
        item {
            CommonButton(text = "Дальше") {
                viewModelWrapper.viewModel.onNextClick()
            }
        }

    }
}
