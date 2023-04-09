package com.lyadsky.nolimits4webapp.android.features.tasks.shapes.layouts

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
fun PredmetConturScreen(viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Совмести предмет с его контуром",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = LocalColors.current.color6,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        val figuresList = listOf(
            R.drawable.ic_elka,
            R.drawable.ic_home_game,
            R.drawable.ic_beach_bolls,
            R.drawable.ic_circle,
            R.drawable.ic_triangle,
            R.drawable.ic_triangle_purple
        )

        LazyVerticalGrid(
            modifier = Modifier
                .weight(1F)
                .padding(top = 76.dp),
            columns = GridCells.Fixed(3)
        ) {
            items(items = figuresList) { item ->
                Column(Modifier.padding(horizontal = 10.dp )) {
                    PredmetConturGridItems(imageId = item, viewModelWrapper = viewModelWrapper)
                }
            }
        }
        val context = LocalContext.current
        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_sound), contentDescription = "",
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .clickable {
                        playAudio(context, R.raw.form)
                    }
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun PredmetConturGridItems(imageId: Int, viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    var color by remember { mutableStateOf(Color.White) }
    var test1 by remember {
        mutableStateOf(false)
    }
    var test2 by remember {
        mutableStateOf(false)
    }
    var test3 by remember {
        mutableStateOf(false)
    }
    var test4 by remember {
        mutableStateOf(false)
    }
    var test5 by remember {
        mutableStateOf(false)
    }
    var test6 by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .size(
                156.dp,
                178.dp
            )
            .shadow(if (color == Color.Red) 0.dp else 4.dp, RoundedCornerShape(15.dp))
            .background(Color.White, RoundedCornerShape(15.dp))
            .border(
                width = if (color == Color.Red) 2.dp else 0.dp,
                color = color,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {

//                if (imageId == R.drawable.ic_circle) {
//                    test1 = true
//                    color = Color.Green
//
//                }
//
//                if (imageId == R.drawable.ic_beach_bolls) {
//                    if (test){
//                        color = Color.Green
//                    }
//                }
//
//
//                if (imageId == R.drawable.ic_circle) {
//
////                    viewModelWrapper.viewModel.onNextClick()
//                } else {
//                    color = Color.Red
//                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(126.dp),
            painter = painterResource(id = imageId),
            contentDescription = "",
            alignment = Alignment.Center
        )
    }
}
