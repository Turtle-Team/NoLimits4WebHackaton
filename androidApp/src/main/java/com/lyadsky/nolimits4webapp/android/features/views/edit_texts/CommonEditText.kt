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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @param textState получать из вью модели
 */

@Composable
fun CommonEditText(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String? = null,
    isCenterText: Boolean = false,
    textState: String = "",
    onValueChanged: (String) -> Unit
) {

    var text by remember { mutableStateOf(textState) }

    Column(modifier) {
        Text(
            text = title, style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992),
                textAlign = if (isCenterText) TextAlign.Center else TextAlign.Start
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
        ) {
            BasicTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                    onValueChanged(newText)
                },
                textStyle = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF9094FB),
                ),
                singleLine = true,
                modifier = Modifier
                    .background(Color(0xFFF1F1F1))
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .height(60.dp),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.padding(start = 15.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (text.isEmpty())
                            Text(
                                text = placeholder ?: title, style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFD9D9D9),
                                ),
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        else
                            innerTextField.invoke()
                    }
                }
            )
        }
    }
}
