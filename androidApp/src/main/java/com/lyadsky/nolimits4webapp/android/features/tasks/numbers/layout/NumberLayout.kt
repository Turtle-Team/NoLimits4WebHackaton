package com.lyadsky.nolimits4webapp.android.features.tasks.numbers.layout

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.bars.CommonTopBar
import com.lyadsky.nolimits4webapp.android.utils.playAudio
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun NumberLayout(
    viewModelWrapper: ViewModelWrapper<TaskViewModel> =
        getViewModel(named("TaskViewModel"))
) {
    Column {
        CommonTopBar(title = "Нажми на цифру!") {
            viewModelWrapper.viewModel.onBackClick()
        }
        Column(
            modifier = Modifier.padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    bottom = 40.dp,
                    start = 16.dp,
                    end = 16.dp,
                    top = 10.dp
                ),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),

                ) {
                val num = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                items(items = num) { item ->
                    GridItems(item = item, context)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GridItems(item: Int, context: Context) {
    Card(
        modifier = Modifier
            .size(156.dp, 178.dp)
            .shadow(4.dp, RoundedCornerShape(15.dp))
            .background(Color.White, RoundedCornerShape(15.dp)),
        onClick = {
            when (item) {
                1 -> playAudio(context, R.raw.odin1)
                2 -> playAudio(context, R.raw.dva2)
                3 -> playAudio(context, R.raw.tri3)
                4 -> playAudio(context, R.raw.chetyer)
                5 -> playAudio(context, R.raw.pjat)
                6 -> playAudio(context, R.raw.shest)
                7 -> playAudio(context, R.raw.sem)
                8 -> playAudio(context, R.raw.vosem)
                9 -> playAudio(context, R.raw.devjat)
                0 -> playAudio(context, R.raw.nol)
                else -> {  }
            }
        }
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = item.toString(),
                fontSize = 64.sp,
                fontWeight = FontWeight(700),
                color = if (item % 2 == 0) Color(0xFF474992) else Color(0xFF98DA7C)
            )
            Text(
                text =
                when (item) {
                    1 -> "Один"
                    2 -> "Два"
                    3 -> "Три"
                    4 -> "Четыре"
                    5 -> "Пять"
                    6 -> "Шесть"
                    7 -> "Семь"
                    8 -> "Восемь"
                    9 -> "Девять"
                    0 -> "Ноль"
                    else -> { "" }
                },
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFFCAC0C9)
            )
        }
    }
}
