package com.lyadsky.nolimits4webapp.android.features.views.edit_texts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonEditText(title: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column {
        Text(
            text = title, style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF9094FB)
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

        BasicTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            textStyle = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF9094FB)
            ),
//            singleLine = true,
            modifier = Modifier
                .background(Color(0xFFF1F1F1))
                .clip(RoundedCornerShape(15.dp))
                .width(328.dp)
                .height(60.dp),
        )
    }
}
