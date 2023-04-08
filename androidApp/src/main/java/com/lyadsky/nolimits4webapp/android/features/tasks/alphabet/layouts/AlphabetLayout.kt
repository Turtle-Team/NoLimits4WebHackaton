package com.lyadsky.nolimits4webapp.android.features.tasks.alphabet.layouts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.bars.CommonTopBar
import com.lyadsky.nolimits4webapp.android.font
import com.lyadsky.nolimits4webapp.android.utils.playAudio
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun AlphabetLayout(
    viewModelWrapper: ViewModelWrapper<TaskViewModel> =
        getViewModel(named("TaskViewModel"))
) {
    Column {

        CommonTopBar(title = "Алфавит") {
            viewModelWrapper.viewModel.onBackClick()
        }

        val letters = listOf<String>(
            "Аа", "Бб", "Вв", "Гг", "Дд", "Ее", "Ёё",
            "Жж", "Зз", "Ии", "Йи", "Кк", "Лл", "Мм",
            "Нн", "Оо", "Пп", "Рр", "Сс", "Тт", "Уу",
            "Фф", "Хх", "Цц", "Чч", "Шш", "Щщ", "Ъъ",
            "Ыы", "Ьь", "Ээ", "Юю", "Яя"
        )

        val context = LocalContext.current

        Column(
            modifier = Modifier.padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                modifier = Modifier,
                columns = GridCells.Adaptive(140.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                items(items = letters) { item ->
                    Column(
                        Modifier.padding(
                            top = 10.dp,
                            bottom = 10.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                    ) {
                        LetterItem(letter = item) {
                            when (item) {
                                "Аа" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.a)
                                }
                                "Бб" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.b)
                                }
                                "Вв" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.v)
                                }
                                "Гг" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.g)
                                }
                                "Дд" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.d)
                                }
                                "Ее" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.e)
                                }
                                "Ёё" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.eo)
                                }
                                "Жж" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.bzbz)
                                }
                                "Зз" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.zov)
                                }
                                "Ии" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.i)
                                }
                                "Йи" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.ii)
                                }
                                "Кк" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.k)
                                }
                                "Лл" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.l)
                                }
                                "Мм" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.m)
                                }
                                "Нн" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.n)
                                }
                                "Оо" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.o)
                                }
                                "Пп" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.p)
                                }
                                "Рр" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.r)
                                }
                                "Сс" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.s)
                                }
                                "Тт" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.t)
                                }
                                "Уу" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.u)
                                }
                                "Фф" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.f)
                                }
                                "Хх" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.h)
                                }
                                "Цц" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.c)
                                }
                                "Чч" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.che)
                                }
                                "Шш" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.sh)
                                }
                                "Щщ" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.scha)
                                }
                                "Ъъ" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.tverd)
                                }
                                "Ыы" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.ui)
                                }
                                "Ьь" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.magk)
                                }
                                "Ээ" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.ee)
                                }
                                "Юю" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.uu)
                                }
                                "ЯЯ" -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.iam)
                                }

                                else -> {}
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LetterItem(letter: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.border(
            width = 2.dp,
            color = Color(0xFFD9D9D9),
            shape = RoundedCornerShape(15.dp)
        ),
        elevation = 3.dp,
        shape = RoundedCornerShape(15.dp),
        onClick = { onClick() }
    ) {
        Column(
            Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_matematic), contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
            )
            Text(
                text = letter, style = TextStyle(
                    fontFamily = font,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF474992)
                )
            )
        }
    }
}
