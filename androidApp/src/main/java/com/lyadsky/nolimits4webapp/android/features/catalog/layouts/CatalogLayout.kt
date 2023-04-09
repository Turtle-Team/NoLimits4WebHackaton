package com.lyadsky.nolimits4webapp.android.features.catalog.layouts

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.font
import com.lyadsky.nolimits4webapp.features.catalog.viewModel.CatalogViewModel
import com.lyadsky.nolimits4webapp.features.profile.viewModel.ProfileViewModel
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun CatalogLayout(

) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = "Выбери занятие!", style = TextStyle(
                fontFamily = font,
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992)
            ),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 60.dp)
        )

        val chapterList = listOf(
            Chapter(R.drawable.ic_alphabet, "Алфавит"),
            Chapter(R.drawable.ic_logic, "Логика"),
            Chapter(R.drawable.ic_numbers, "Цифры"),
            Chapter(R.drawable.ic_forms, "Формы"),
            Chapter(R.drawable.ic_matematic, "Математика"),
            Chapter(R.drawable.ic_colors, "Цвета"),
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
                Column(Modifier.padding(top = 10.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)) {
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChapterItem(
    chapter: Chapter, viewModelWrapper: ViewModelWrapper<CatalogViewModel> =
        getViewModel(named("CatalogViewModel"))
) {
    Card(
        modifier = Modifier.border(
            width = 2.dp,
            color = Color(0xFFD9D9D9),
            shape = RoundedCornerShape(15.dp)
        ),
        elevation = 3.dp,
        shape = RoundedCornerShape(15.dp),
        onClick = {
            when (chapter.title) {
                "Алфавит" -> viewModelWrapper.viewModel.onAlphabetClick()
                "Логика" -> viewModelWrapper.viewModel.onLogicClick()
                "Формы" -> viewModelWrapper.viewModel.onShapeClick()
                "Математика" -> viewModelWrapper.viewModel.onMathematicClick()
                "Цифры" -> viewModelWrapper.viewModel.onNumberClick()
                "Цвета" -> viewModelWrapper.viewModel.onColorClick()
            }
        }
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
                    fontFamily = font,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF474992)
                )
            )
        }
    }
}
