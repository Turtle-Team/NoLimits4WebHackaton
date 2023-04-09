package com.lyadsky.nolimits4webapp.android.features.helicopterMinigame

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.features.helicopterMinigame.HelicopterMinigameViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun HelicopterMinigame(
    viewModel: ViewModelWrapper<HelicopterMinigameViewModel> = getViewModel(named("HelicopterViewModel"))
) {

    val state = viewModel.viewModel.state.collectAsState()

//    val helicAnim = rememberInfiniteTransition().animateFloat(
//        initialValue = 0F,
//        targetValue = 15F,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 500, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse,
//        )
//    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF66DFE7))
    ) {

        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopCenter),
            text = state.value.score.toString(),
            fontWeight = FontWeight(700),
            fontSize = 60.sp,
            color = LocalColors.current.color4
        )

        Box(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
//            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterStart),
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    modifier = Modifier
                        .padding(10.dp),
//                        .offset(y = helicAnim.value.dp),
                    painter = painterResource(id = R.drawable.helicopter),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier.padding(10.dp),
                    text = state.value.answer.toString(),
                    fontWeight = FontWeight(700),
                    fontSize = 128.sp,
                    color = Color(0xFF474992)
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterEnd),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.End
            ) {
                Box(
                    modifier = Modifier.clickable(
                        MutableInteractionSource(),
                        indication = null
                    ) {
                        viewModel.viewModel.onCloudClick(state.value.firstExp.second)
                    },
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cloud),
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = state.value.firstExp.first,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                        color = Color(0xFF474992)
                    )
                }
                Box(
                    modifier = Modifier.clickable(
                        MutableInteractionSource(),
                        indication = null
                    ) {
                        viewModel.viewModel.onCloudClick(state.value.secondExp.second)
                    },
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cloud),
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = state.value.secondExp.first,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                        color = Color(0xFF474992)
                    )
                }
                Box(
                    modifier = Modifier.clickable(
                        MutableInteractionSource(),
                        indication = null
                    ) {
                        viewModel.viewModel.onCloudClick(state.value.thirdExp.second)
                    },
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cloud),
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = state.value.thirdExp.first,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                        color = Color(0xFF474992)
                    )
                }
            }
        }

        IconButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 10.dp),
            onClick = { viewModel.viewModel.navigateBack() }) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}