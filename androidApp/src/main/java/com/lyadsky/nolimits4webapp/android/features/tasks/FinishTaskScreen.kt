package com.lyadsky.nolimits4webapp.android.features.tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.features.finish.viewModel.FinishViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun FinishTaskScreen(viewModelWrapper: ViewModelWrapper<FinishViewModel> =
                         getViewModel(named("FinishViewModel"))
) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 112.dp)) {
            Text(
                text = "Уровень повышен", modifier = Modifier
                    .padding(top = 120.dp)
                    .background(Color(0xFFFB80A5), shape = RoundedCornerShape(15.dp))
                    .width(157.dp)
                    .height(25.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
            )
            Text(
                text = "Молодец", modifier = Modifier
                    .padding(top = 36.dp),
                color = Color(0xFF474992),
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_winner),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 30.dp)
            )
            Text(
                text = "3/3", modifier = Modifier
                    .padding(top = 30.dp),
                color = Color(0xFF474992),
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        }
        Column(Modifier.padding(top = 240.dp)) {
            CommonButton(
                text = "Дальше", modifier = Modifier, width = 328,
                height = 50
            ) {
                viewModelWrapper.viewModel.onNextClick()
            }
        }
    }
}
