package com.lyadsky.nolimits4webapp.android.features.register.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.catalog.layouts.Chapter
import com.lyadsky.nolimits4webapp.android.features.catalog.layouts.ChapterItem
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.font
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.lyadsky.nolimits4webapp.features.catalog.viewModel.CatalogViewModel
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun HobbiesScreen(
    viewModelWrapper: ViewModelWrapper<RegisterViewModel>,
    userData: UserDataManager = get()
) {

    val isHorizontal = LocalConfiguration.current.orientation == 2

    val chapterList = listOf(
        Chapter(R.drawable.ic_alphabet, "Алфавит"),
        Chapter(R.drawable.ic_logic, "Логика"),
        Chapter(R.drawable.ic_numbers, "Цифры"),
        Chapter(R.drawable.ic_forms, "Формы"),
        Chapter(R.drawable.ic_matematic, "Математика"),
        Chapter(R.drawable.ic_colors, "Цвета"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выбери, что тебе нравится!",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = LocalColors.current.color6
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
                    LikeChapterItem(chapter = item)
                }
            }
            item {
                CommonButton(text = "Создать") {
                    viewModelWrapper.viewModel.onNextClick()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LikeChapterItem(
    chapter: Chapter, viewModelWrapper: ViewModelWrapper<CatalogViewModel> =
        getViewModel(named("CatalogViewModel"))
) {
    var color by remember {
        mutableStateOf(Color.White)
    }

    Card(
        modifier = Modifier.border(
            width = 2.dp,
            color = color,
            shape = RoundedCornerShape(15.dp)
        ),
        elevation = 3.dp,
        shape = RoundedCornerShape(15.dp),
        onClick = {
            color = if (color == Color.White){
                Color(0xFF9094FB)
            } else {
                Color.White
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
