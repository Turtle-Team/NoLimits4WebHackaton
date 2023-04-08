package com.lyadsky.nolimits4webapp.android.features.catalog.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R

@Composable
fun CatalogLayout() {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = "Выбери занятие!", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992)
            ),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 60.dp)
        )

        val chapterList = listOf(
            Chapter(R.drawable.ic_alphabet, "Алфавит"),
            Chapter(R.drawable.ic_numbers, "Цифры"),
            Chapter(R.drawable.ic_forms, "Формы"),
            Chapter(R.drawable.ic_matematic, "Математика"),
            Chapter(R.drawable.ic_colors, "Цвета"),
            Chapter(R.drawable.ic_english, "Английский"),
        )

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 20.dp),
            columns = GridCells.Adaptive(150.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            items(items = chapterList) { item ->
                Column(Modifier.padding(top = 10.dp, bottom = 10.dp ,start = 16.dp, end = 16.dp)) {
                    ChapterItem(chapter = item)
                }
            }
        }
    }
}

data class Chapter(
    val imageId: Int,
    val title: String
)

@Composable
fun ChapterItem(chapter: Chapter) {
    Card(
        modifier = Modifier.border(
            width = 2.dp,
            color = Color(0xFFD9D9D9),
            shape = RoundedCornerShape(15.dp)
        ),
        elevation = 3.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = chapter.imageId), contentDescription = "",
                modifier = Modifier
                    .size(125.dp)
            )
            Text(
                text = chapter.title, style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF474992)
                )
            )
        }
    }
}
