package com.lyadsky.nolimits4webapp.android.features.tasks.logic.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun PutDownCardScreen(viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Найди самый большой шарик",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = LocalColors.current.color6
        )

        val bollsList = listOf(
            R.drawable.ic_bolls,
            R.drawable.ic_bolls_2,
            R.drawable.ic_bolls_3
        )
        LazyRow(
            modifier = Modifier
                .weight(1F)
                .padding(top = 50.dp),
        ) {
            items(items = bollsList) { item ->
                PutDownCardItem(imageId = item, viewModelWrapper = viewModelWrapper)
            }
        }
        val context = LocalContext.current
        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_sound), contentDescription = "",
                modifier = Modifier
                    .padding(bottom = 70.dp)
                    .clickable {
                        playAudio(context, R.raw.find_boll)
                    }
            )
        }
    }
}

@Composable
fun PutDownCardItem(imageId: Int, viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    var color by remember { mutableStateOf(Color.White) }
    Column(
        modifier = Modifier
            .size(
                86.dp,
                120.dp
            )
            .background(Color.White, RoundedCornerShape(15.dp))
            .border(
                width = if (color == Color.Red) 2.dp else 0.dp,
                color = color,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {
                if (imageId == R.drawable.ic_bolls_3) {
                    color = Color.Green
                    viewModelWrapper.viewModel.onNextClick()
                } else {
                    color = Color.Red
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = ""
        )
    }
}
