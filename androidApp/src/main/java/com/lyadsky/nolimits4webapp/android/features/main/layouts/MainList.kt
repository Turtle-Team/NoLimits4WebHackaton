package com.lyadsky.nolimits4webapp.android.features.main.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R.drawable
import com.lyadsky.nolimits4webapp.android.font

@Composable
fun MainList() {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 60.dp, horizontal = 16.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(
                    text = "Начнём развлекаться?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = LocalColors.current.color6
                )
                Text(
                    text = "Выбери, чем хочешь заняться:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF9C9C9C)
                )
            }
        }
        item {

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .height(138.dp)
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(15.dp))
                    .background(LocalColors.current.background, RoundedCornerShape(15.dp))
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(115.dp, 96.dp),
                    painter = painterResource(id = drawable.monke_dumaet),
                    contentDescription = ""
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.Top)
                        .weight(1F)
                        .padding(top = 13.dp)
                ) {
                    Text(
                        text = "Английский",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = LocalColors.current.color6
                    )
                    Text(
                        text = "Повторение слов",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFD9D9D9)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(70.dp)
                        .padding(vertical = 13.dp),
                    horizontalAlignment =
                    Alignment.End, verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "50%",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = LocalColors.current.color6
                    )

                    Box(
                        modifier = Modifier
                            .size(57.dp)
                            .border(1.dp, Color(0xFFD9D9D9), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.padding(start = 1.dp),
                            painter = painterResource(id = drawable.ic_play),
                            contentDescription = "",
                            tint = LocalColors.current.color5
                        )
                    }
                }
            }
        }

        item {
            Text(
                modifier = Modifier.padding(top = 35.dp),
                text = "Тебе понравится!",
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = LocalColors.current.color6
            )
        }

        item {
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .height(138.dp)
                    .fillMaxWidth()
                    .background(Color(0x4A66DFE7), RoundedCornerShape(15.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(6F)
                        .background(
                            Color(0xFF66DFE7),
                            RoundedCornerShape(15.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(drawable.helicopter_and_oblaka),
                        contentDescription = ""
                    )
                }
                Column(
                    Modifier.fillMaxSize().weight(4F),
                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Счёт в облаках",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = LocalColors.current.color6
                    )
                    Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = LocalColors.current.color5)) {
                        Text(
                            text = "Играть",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(700),
                            color = Color.White,
                            fontFamily = font
                        )
                    }
                }
            }
        }
        item {
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .height(138.dp)
                    .fillMaxWidth()
                    .background(Color(0x4AFAE1A4), RoundedCornerShape(15.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier.fillMaxSize().weight(4F),
                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Дождь из букв",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = LocalColors.current.color6
                    )
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = LocalColors.current.color6)) {
                        Text(
                            text = "Играть",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(700),
                            color = Color.White,
                            fontFamily = font
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(6F)
                        .background(
                            Color(0xFFFAE1A4),
                            RoundedCornerShape(15.dp)
                        ).padding(10.dp),
                    Alignment.BottomStart
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.TopCenter).offset(x = 20.dp),
                        text = "Д",
                        fontSize = 40.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White,
                        fontFamily = font
                    )
                    Text(
                        modifier = Modifier.align(Alignment.CenterEnd).offset(x = (-20).dp,y = 10.dp),
                        text = "Р",
                        fontSize = 40.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White,
                        fontFamily = font
                    )
                    Image(
                        painter = painterResource(drawable.monkey_umbrella),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}