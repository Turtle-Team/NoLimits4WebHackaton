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

        val letters = listOf(
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

                                else -> {
                                    Log.e("click", "click")
                                    playAudio(context, R.raw.iam)
                                }
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
            Modifier
                .padding(15.dp)
                .width(156.dp)
                .height(178.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (letter) {
                "Аа" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_shark),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Акула", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Бб" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_squirrel),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Белка", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Вв" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_camel),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Верблюд", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Гг" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_viper),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Гадюка", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Дд" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dolphin),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Дельфин", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 30.dp)
                        )
                    }
                }
                "Ее" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_raccoon),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Енот", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Ёё" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_hedgehog),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Ёж", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Жж" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_girraffe),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Жираф", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Зз" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_zebra),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Зебра", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Ии" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_iguana),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Хамилион", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Йи" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_york),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Йорк", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Кк" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_whale),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Кит", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Лл" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_frog),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Лягушка", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Мм" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_walrus),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Морж ", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 40.dp)
                        )
                    }
                }
                "Нн" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_rhinoceros),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Носорог", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Оо" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_octopus),
                        contentDescription = ""
                    )


                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Осьминог", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Пп" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_penguin),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Пингвин", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Рр" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_fish),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Рыба", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Сс" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_elephant),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Слон", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Тт" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_tiger),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Тигр", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Уу" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_duck),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Утка", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Фф" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_flamingo),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Фламинго", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Хх" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_hamster),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Хомяк", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Цц" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_heron),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Цапля", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Чч" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_turtle),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Черепаха", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Шш" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_shimpanze),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Шимпанзе", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Щщ" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_shuka),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Щука", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Ъъ" -> {
                    Text(
                        text = letter, style = TextStyle(
                            fontFamily = font,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF474992)
                        )
                    )
                }
                "Ыы" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_mouse),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Мышь", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Ьь" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_lynx),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Рысь", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Ээ" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_emu),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Эму", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "Юю" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_lemur),
                        contentDescription = ""
                    )
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Лемур", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                "ЯЯ" -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_lizard),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Ящерица", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }

                else -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_lizard),
                        contentDescription = ""
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 50.dp)
                    ) {
                        Text(
                            text = letter, style = TextStyle(
                                fontFamily = font,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF474992)
                            )
                        )
                        Text(
                            text = "Ящерица", style = TextStyle(
                                fontFamily = font,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFCAC0C9)
                            ),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }

            }
        }
    }
}
