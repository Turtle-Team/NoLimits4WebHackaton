package com.lyadsky.nolimits4webapp.android.features.views.edit_texts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonEditText(title: String, placeholder: String? = title, isCenterText: Boolean? = false) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column {
        Text(
            text = title, style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992)
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        )
//        TextField(
//            value = text,
//            onValueChange = { newText ->
//                text = newText
//            },
//            placeholder = { Text(text = title) }
//        )
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
        ) {
            BasicTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                textStyle = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF9094FB),
                    textAlign = TextAlign.Center
                ),
//            singleLine = true,
                modifier = Modifier
                    .background(Color(0xFFF1F1F1))
                    .clip(RoundedCornerShape(15.dp))
                    .width(328.dp)
                    .height(60.dp),
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = if (isCenterText == true) Arrangement.Center else Arrangement.Start //TODO поправить
                    ) {
                        Text(
                            text = placeholder.toString(), style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFD9D9D9),
                            ),
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }
                }
            )
        }
    }
}
