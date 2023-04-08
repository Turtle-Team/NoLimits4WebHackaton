package com.lyadsky.nolimits4webapp.android.features.main.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors

@Composable
fun MainList() {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 60.dp, horizontal = 16.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
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

        }
    }
}