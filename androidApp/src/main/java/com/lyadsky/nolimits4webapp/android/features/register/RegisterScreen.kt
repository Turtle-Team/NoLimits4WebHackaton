package com.lyadsky.nolimits4webapp.android.features.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.bars.StageBar
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import com.lyadsky.nolimits4webapp.features.welcome.viewModel.WelcomeViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun RegisterScreen(
    viewModelWrapper: ViewModelWrapper<RegisterViewModel> =
        getViewModel(named("RegisterViewModel"))
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 50.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        StageBar(number = 1)
        Divider(Modifier.padding(top = 52.dp), color = Color.White)

        CommonEditText(title = "Имя пользователя")
        Divider(Modifier.padding(top = 30.dp), color = Color.White)

        CommonEditText(title = "Электронная почта")
        Divider(Modifier.padding(top = 30.dp), color = Color.White)

        CommonEditText(title = "Пароль")

        Divider(Modifier.padding(top = 140.dp), color = Color.White)
        CommonButton(text = "Дальше") {
            viewModelWrapper.viewModel.onNextClick()
        }

    }
}
