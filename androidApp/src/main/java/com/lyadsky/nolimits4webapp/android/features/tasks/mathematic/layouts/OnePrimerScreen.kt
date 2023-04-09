package com.lyadsky.nolimits4webapp.android.features.tasks.mathematic.layouts

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.utils.playAudio
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel

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

        val startLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val result = it.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                viewModelWrapper.viewModel.onNextClick(
                    result?.get(0).toString() == "5" || result?.get(0).toString() == "пять"
                )
            }
        }
        val context = LocalContext.current
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

//            item {
//                Row(horizontalArrangement = Arrangement.Center) {
//                    val context = LocalContext.current
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_sound),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .padding(bottom = 70.dp)
//                            .clickable(
//                                MutableInteractionSource(),
//                                indication = rememberRipple(bounded = true)
//                            ) {
//
//
//                            }
//                    )
//                }
//            }


        }
        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_sound), contentDescription = "",
                modifier = Modifier.padding(bottom = 10.dp).clickable { playAudio(context, R.raw.draw_number) }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_micro), contentDescription = "",
                modifier = Modifier.padding(bottom = 10.dp, start = 174.dp).clickable {
                    startLauncher.launch(Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH))
                }
            )
        }
    }
}

@Composable
fun SpeakableText(text: String, textToSpeech: TextToSpeech) {
    Text(
        text = text,
        modifier = Modifier.clickable {
            textToSpeech.speak(
                text,
                TextToSpeech.QUEUE_FLUSH,
                null
            )
        }
    )
}
