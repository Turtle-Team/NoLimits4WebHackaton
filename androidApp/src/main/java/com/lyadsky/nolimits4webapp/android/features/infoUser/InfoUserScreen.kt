package com.lyadsky.nolimits4webapp.android.features.infoUser

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.features.views.bars.StageBar
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText


@SuppressLint("UnrememberedMutableState")
@Composable
fun InfoUserScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var ageSelected by remember { mutableStateOf(0) }

        StageBar(number = 2)
        Divider(Modifier.padding(top = 42.dp), color = Color.White)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_penguin), contentDescription = "",
            )
            Divider(Modifier.padding(top = 35.dp), color = Color.White)
            CommonEditText(
                title = "Как тебя зовут?",
                placeholder = "Введи свое имя",
                isCenterText = true
            ){}
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 35.dp)
        ) {
            Text(
                text = "Сколько тебе лет?", style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF474992)
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            val age = listOf(1, 2, 3, 4, 5, 6, 7)

            LazyRow(modifier = Modifier.padding(top = 15.dp), verticalAlignment = Alignment.CenterVertically) {
                items(items = age) { item ->
                    if (ageSelected == item){
                        Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = item.toString(), style = TextStyle(
                                    color = Color(0xFF9094FB),
                                    fontSize = 48.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(700)
                                ),
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .clickable { ageSelected = item }
                                    .border(
                                        width = 2.dp,
                                        color = Color(0xFF9094FB),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .width(50.dp)
                                    .height(70.dp)
                            )
                        }
                    } else {
                        Text(
                            text = item.toString(), style = TextStyle(
                                color = Color(0xFFD9D9D9),
                                fontSize = 40.sp,
                                fontWeight = FontWeight(700)
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .clickable { ageSelected = item }
                        )
                    }
                }
            }
            Text(
                text = ageSelected.toString(), style = TextStyle(
                    color = Color(0xFFD9D9D9),
                    fontSize = 40.sp,
                    fontWeight = FontWeight(700)
                )
            )
        }


        Divider(Modifier.padding(top = 40.dp), color = Color.White)
        CommonButton(text = "Дальше") {

        }
    }
}
