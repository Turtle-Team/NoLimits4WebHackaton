package com.lyadsky.nolimits4webapp.android.features.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.font
import com.lyadsky.nolimits4webapp.features.welcome.viewModel.WelcomeViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun WelcomeScreen(
    viewModelWrapper: ViewModelWrapper<WelcomeViewModel> =
        getViewModel(named("WelcomeViewModel"))
) {
    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.size(204.dp),
                    painter = painterResource(id = R.drawable.monkey_clown), contentDescription = "",
                )
                Text(
                    text = "Детское приложение",
                    modifier = Modifier
                        .padding(top = 34.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = font,
                        color = Color(0xFF494949),
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp,
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

        item {
            Column(
                Modifier.padding(top = 140.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CommonButton(text = "Войти в аккаунт") {
                    viewModelWrapper.viewModel.onAuthClick()
                }
                Spacer(Modifier.padding(top = 10.dp))
                CommonButton(
                    text = "Зарегистрироваться",
                    color = Color(0xFFFEB242),
                ) {
                    viewModelWrapper.viewModel.onRegisterClick()
                }
            }
        }
    }
}
