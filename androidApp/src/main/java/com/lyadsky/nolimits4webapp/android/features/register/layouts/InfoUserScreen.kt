package com.lyadsky.nolimits4webapp.android.features.infoUser

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel


@SuppressLint("UnrememberedMutableState")
@Composable
fun InfoUserScreen(
    viewModelWrapper: ViewModelWrapper<RegisterViewModel>
) {

    val state = viewModelWrapper.viewModel.state.collectAsState()

    LazyColumn(
        Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(top = 40.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_penguin), contentDescription = "",
            )
        }

        item {
            CommonEditText(
                modifier = Modifier.padding(horizontal = 47.dp),
                title = "Как тебя зовут?",
                textState = state.value.name,
                placeholder = "Введи свое имя",
                isCenterText = true
            ) { viewModelWrapper.viewModel.onNameChanged(it) }
        }

        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Сколько тебе лет?",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF474992)
                    ),
                )
                AgeSelector(
                    age = state.value.age,
                    onAgeChanged = { viewModelWrapper.viewModel.onAgeChanged(it) })
            }
        }

        item {
            CommonButton(text = "Дальше") {
                viewModelWrapper.viewModel.onNextClick()
            }
        }
    }
}

@Composable
fun AgeSelector(age: Int, onAgeChanged: (Int) -> Unit) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy(19.dp)
    ) {
        items(count = 7) { count ->
            val it = count + 1

            val style = if (age != it) TextStyle(
                color = Color(0xFFD9D9D9),
                fontSize = 40.sp
            ) else TextStyle(
                color = LocalColors.current.color1,
                fontSize = 48.sp
            )

            Box(
                modifier = Modifier.size(60.dp, 70.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(49.dp, 58.dp)
                        .border(
                            2.dp,
                            if (age == it) LocalColors.current.color1 else Color.Transparent,
                            RoundedCornerShape(10.dp)
                        )
                        .clickable(
                            MutableInteractionSource(),
                            indication = null
                        ) { onAgeChanged(it) },
                )
                Text(
                    text = it.toString(),
                    fontWeight = FontWeight(700),
                    style = style
                )
            }
        }
    }
}
