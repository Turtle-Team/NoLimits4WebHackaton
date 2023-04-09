package com.lyadsky.nolimits4webapp.android.features.register.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R


@Composable
fun StartScreen(onNextClick: () -> Unit) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            vertical = 50.dp,
            horizontal = 16.dp
        )
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hello_monke),
                    contentDescription = ""
                )
                Text(
                    text = "Привет!",
                    fontWeight = FontWeight(700),
                    fontSize = 24.sp,
                    color = LocalColors.current.color6
                )
            }
        }
        item {
            val colors = LocalColors.current.color1
            Button(
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colors),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(49.dp),
                onClick = onNextClick
            ) {
                Text(
                    text = "Дальше",
                    fontWeight = FontWeight(700),
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
        }
    }
}