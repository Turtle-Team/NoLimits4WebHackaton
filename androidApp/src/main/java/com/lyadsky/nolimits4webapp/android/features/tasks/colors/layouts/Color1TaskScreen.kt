package com.lyadsky.nolimits4webapp.android.features.tasks.colors.layouts

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.utils.playAudio
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel

@Composable
fun Color1TaskScreen(viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    val colors = listOf(
        Color(0xFF225CF1),
        Color(0xFFFEAD4E),
        Color(0xFF98DA7C),
        Color(0xFFD92626)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выбери зеленный цвет",
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
            items(items = colors) { item ->
                SelectColorGreenGridItems(item, viewModelWrapper)
            }
        }
        val context = LocalContext.current
        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_sound), contentDescription = "",
                modifier = Modifier.padding(bottom = 70.dp).clickable {
                    playAudio(context, R.raw.select_lishnie)
                }
            )
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun SelectColorGreenGridItems(back: Color, viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    var color by remember { mutableStateOf(Color.White) }
    Column(
        modifier = Modifier
            .size(
                156.dp,
                178.dp
            )
            .shadow(if (color == Color.Red) 0.dp else 4.dp, RoundedCornerShape(15.dp))
            .background(back, RoundedCornerShape(15.dp))
            .border(
                width = if (color == Color.Red) 2.dp else 0.dp,
                color = color,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {
                if (back == Color(0xFF98DA7C)) {
                    color = Color.Green
                    viewModelWrapper.viewModel.onNextClick()
                } else {
                    color = Color.Red
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
    }
}
