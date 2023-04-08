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
            color = LocalColors.current.color6
        )

//        val startLauncher = rememberLauncherForActivityResult(
//            contract = ActivityResultContracts.StartActivityForResult()
//        ) {
//            if (it.resultCode == Activity.RESULT_OK) {
//                val result = it.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//                viewModelWrapper.viewModel.onSearchChange(result?.get(0).toString())
//                viewModelWrapper.viewModel.onSearchClick()
//            }
//        }

        LazyColumn {

            item {
                Icon(
                    painter = painterResource(id = R.drawable.ic_micro), contentDescription = "",
                    modifier = Modifier.size(68.dp)
                        .clickable {
//                            try {
//                                Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
//                            } catch (e: ActivityNotFoundException) {
//                                CoroutineScope(Dispatchers.Main).launch {
//                                    errorService.showError("Нет сервиса распознавания речи")
//                                }
//                            }
                        }
                )
            }

//            item {
//                Text(
//                    text = "... + 5 = 10",
//                    fontSize = 48.sp,
//                    fontWeight = FontWeight(700),
//                    color = LocalColors.current.color6,
//                    modifier = Modifier.padding(top = 45.dp)
//                )
//            }
//            item {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_matematic), contentDescription = "",
////            modifier = Modifier.padding(top = 47.dp)
//                )
//            }
        }
    }
}

@Composable
fun SpeakableText(text: String, textToSpeech: TextToSpeech) {
    Text(
        text = text,
        modifier = Modifier.clickable { textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null) }
    )
}
