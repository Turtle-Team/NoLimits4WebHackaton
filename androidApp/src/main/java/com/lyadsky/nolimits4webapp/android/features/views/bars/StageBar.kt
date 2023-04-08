package com.lyadsky.nolimits4webapp.android.features.views.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R

@Composable
fun StageBar(modifier: Modifier = Modifier,number: Int) {
    Row (modifier = modifier,horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "$number", modifier = Modifier
                .background(
                    color = if (number == 1) Color(0xFF9094FB) else Color(0xFFF1F1F1),
                    shape = CircleShape
                )
                .size(25.dp),
            style = TextStyle(
                color = if (number == 1) Color.White else Color(0xFFD9D9D9),
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                fontWeight = FontWeight(700)
            )
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_line_stage), contentDescription = "",
            tint = if (number == 1) Color(0xFF9094FB) else Color(0xFFD9D9D9),
            modifier = Modifier.padding(horizontal = 3.dp).width(16.dp)
        )

        Text(
            text = "$number", modifier = Modifier
                .background(
                    color = if (number == 2) Color(0xFF9094FB) else Color(0xFFF1F1F1),
                    shape = CircleShape
                )
                .size(25.dp),
            style = TextStyle(
                color = if (number == 2) Color.White else Color(0xFFD9D9D9),
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                fontWeight = FontWeight(700)
            )
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_line_stage), contentDescription = "",
            tint = if (number == 2) Color(0xFF9094FB) else Color(0xFFD9D9D9),
            modifier = Modifier.padding(horizontal = 3.dp)
        )

        Text(
            text = "$number", modifier = Modifier
                .background(
                    color = if (number == 3) Color(0xFF9094FB) else Color(0xFFF1F1F1),
                    shape = CircleShape
                )
                .size(25.dp),
            style = TextStyle(
                color = if (number == 3) Color.White else Color(0xFFD9D9D9),
                fontSize = 18.sp,
                textAlign = TextAlign.Center ,
                fontWeight = FontWeight(700)
            )
        )
    }
}
