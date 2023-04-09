package com.lyadsky.nolimits4webapp.android.features.tasks.mathematic.layouts

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.MainActivity
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.bars.CommonTopBar
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun OnePrimerScreen(viewModelWrapper: ViewModelWrapper<TaskViewModel>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Нарисуй нужное число в поле внизу или скажи ответ в микрофон",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = LocalColors.current.color6,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {

            item {
                Text(
                    text = "... + 5 = 10",
                    fontSize = 48.sp,
                    fontWeight = FontWeight(700),
                    color = LocalColors.current.color6,
                    modifier = Modifier.padding(top = 25.dp)
                )
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_matematic),
                    contentDescription = "",
                    modifier = Modifier.padding(top = 47.dp)
                )
            }
            item {
                CommonButton(
                    text = "Далее",
                    width = 200,
                    height = 80,
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    viewModelWrapper.viewModel.onNextClick()
                }
            }
        }

        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_sound), contentDescription = "",
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_micro), contentDescription = "",
                modifier = Modifier.padding(bottom = 10.dp, start = 174.dp)
            )
        }
    }
}
