package com.lyadsky.nolimits4webapp.android.features.tasks.logic.layouts

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel

@Composable
fun SelectBatterflyScreen(
    viewModelWrapper: ViewModelWrapper<TaskViewModel>
) {
    val batterfly = listOf(
        R.drawable.ic_batterfly_pink,
        R.drawable.ic_batterfly_blue,
        R.drawable.ic_batterfly_turquoise,
        R.drawable.ic_bird
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выбери лишнее",
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
            items(items = batterfly) { item ->
                SelectBatterflyGridItems(item, viewModelWrapper)
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
fun SelectBatterflyGridItems(imageId: Int, viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
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
                if (imageId == R.drawable.ic_bird) {
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
