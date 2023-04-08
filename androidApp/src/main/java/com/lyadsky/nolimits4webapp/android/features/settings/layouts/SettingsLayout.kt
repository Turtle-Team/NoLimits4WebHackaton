package com.lyadsky.nolimits4webapp.android.features.settings.layouts

import android.media.MediaPlayer
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.bars.CommonTopBar
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText
import com.lyadsky.nolimits4webapp.android.font
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.lyadsky.nolimits4webapp.features.settings.viewModel.SettingsViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun SettingsLayout(
    viewModelWrapper: ViewModelWrapper<SettingsViewModel> =
        getViewModel(named("SettingsViewModel")),
) {
    Column(Modifier.fillMaxWidth()) {
        CommonTopBar(title = "Настройки") {
            viewModelWrapper.viewModel.onBackClick()
        }

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {

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
                Text(
                    text = "Егор", modifier = Modifier.padding(top = 7.dp),
                    color = Color(0xFFC7C7C7),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
            item {
                ChangeTheme()
            }
        }
    }
}

@Composable
fun ChangeTheme(lightTheme: Boolean = true) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, top = 30.dp)
    ) {
        Text(
            text = "Выберите тему приложения", style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992)
            )
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(155.dp)
                    .height(65.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        width = 2.dp,
                        color = if (lightTheme) Color(0xFFDCDCDC) else Color(0xFF474992),
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                )
            ) {
                Text(
                    text = "Темная",
                    color = if (lightTheme) Color(0xFFDCDCDC) else Color(0xFF474992),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = font
                )
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(155.dp)
                    .height(65.dp)
                    .padding(start = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        width = 2.dp,
                        color = if (!lightTheme) Color(0xFFDCDCDC) else Color(0xFF474992),
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                )
            ) {
                Text(
                    text = "Темная",
                    color = if (!lightTheme) Color(0xFFDCDCDC) else Color(0xFF474992),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = font
                )
            }
        }
    }
}
