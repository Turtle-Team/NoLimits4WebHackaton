package com.lyadsky.nolimits4webapp.android.features.tasks.logic.layouts

import android.annotation.SuppressLint
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.register.layouts.GridItems
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel
import java.util.*


@Composable
fun SelectAppleScreen(
    viewModelWrapper: ViewModelWrapper<TaskViewModel>
) {
    val fructsList = listOf(
        R.drawable.ic_green_apple,
        R.drawable.ic_limone,
        R.drawable.ic_apple,
        R.drawable.ic_peppers
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выбери красное яблоко",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = LocalColors.current.color6
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 50.dp, start = 16.dp, end = 16.dp),
            modifier = Modifier
                .weight(1F)
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

            ) {
            items(items = fructsList) { item ->
                SelectAppleGridItems(item, viewModelWrapper)
            }
            item {
                Icon(
                    painter = painterResource(id = R.drawable.ic_mic), contentDescription = "",
                    modifier = Modifier.padding(top = 70.dp), tint = Color(0xFF474992)
                )
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun SelectAppleGridItems(imageId: Int, viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    var color by remember { mutableStateOf(Color.White) }
    Column(
        modifier = Modifier
            .size(
                156.dp,
                178.dp
            )
            .shadow(4.dp, RoundedCornerShape(15.dp))
            .background(color, RoundedCornerShape(15.dp))
            .clickable {
                if (imageId == R.drawable.ic_apple) {
                    color = Color.Green
                    viewModelWrapper.viewModel.onNextClick()
                }else {
                    color =  Color.Red
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(126.dp),
            painter = painterResource(id = imageId),
            contentDescription = ""
        )
    }
}
