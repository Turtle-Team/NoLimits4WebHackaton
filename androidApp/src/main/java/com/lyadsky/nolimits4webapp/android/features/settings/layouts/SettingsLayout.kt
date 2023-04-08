package com.lyadsky.nolimits4webapp.android.features.settings.layouts

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText
import com.lyadsky.nolimits4webapp.features.settings.viewModel.SettingsViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun SettingsLayout(
    viewModelWrapper: ViewModelWrapper<SettingsViewModel> =
        getViewModel(named("SettingsViewModel"))
) {
    Column(Modifier.fillMaxWidth()) {
        SettingsTopBar {
            viewModelWrapper.viewModel.onBackClick()
        }

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {

            item {
                Spacer(modifier = Modifier.padding(top = 35.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_circle), contentDescription = "",
                    modifier = Modifier
                        .size(75.dp)
                        .border(width = 2.dp, color = Color(0xFFC7C7C7), shape = CircleShape)
                        .padding(horizontal = 100.dp),
                    tint = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 54.dp))
                CommonEditText(title = "Имя пользователя", sizeText = 16)

                Spacer(modifier = Modifier.padding(top = 30.dp))
                CommonEditText(title = "Электронная почта", sizeText = 16)

                Spacer(modifier = Modifier.padding(top = 30.dp))
                CommonEditText(title = "Пароль", sizeText = 16)

                Column(
                    Modifier
                        .padding(top = 20.dp, bottom = 40.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ChangeTheme()
                    Text(
                        text = "Выход из аккаунта", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFB4B4B4),
                            textAlign = TextAlign.Center
                        ), modifier = Modifier.padding(top = 30.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SettingsTopBar(backButton: () -> Unit) {
    Row(modifier = Modifier.padding(start = 25.dp, top = 50.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back), contentDescription = "",
            tint = Color(0xFF474992),
            modifier = Modifier
                .width(26.dp)
                .height(22.dp)
                .clickable { backButton() }
        )
        Text(
            text = "Настройки", modifier = Modifier.padding(start = 20.dp, bottom = 20.dp), style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992)
            )
        )
    }
}

@Composable
fun ChangeTheme() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 32.dp)) {
        Text(
            text = "Выберите тему приложения", style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992)
            )
        )
        Row(Modifier.padding(top = 20.dp), horizontalArrangement = Arrangement.Center) {
            Column(
                modifier = Modifier
                    .width(156.dp)
                    .height(64.dp)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF474992)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Темная", modifier = Modifier.padding(start = 16.dp), style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF474992)
                    )
                )
            }

            Column(
                modifier = Modifier
                    .width(156.dp)
                    .height(64.dp)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF474992)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Светлая", modifier = Modifier.padding(start = 16.dp), style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF474992)
                    )
                )
            }
        }
    }
}
