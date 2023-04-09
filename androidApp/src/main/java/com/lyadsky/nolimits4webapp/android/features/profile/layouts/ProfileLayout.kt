package com.lyadsky.nolimits4webapp.android.features.profile.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.data.TaskStats
import com.lyadsky.nolimits4webapp.features.profile.viewModel.ProfileViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.qualifier.named

@Composable
fun ProfileLayout(
    viewModelWrapper: ViewModelWrapper<ProfileViewModel> =
        getViewModel(named("ProfileViewModel"))
) {

    val state = viewModelWrapper.viewModel.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
    ) {
        state.value?.let { CategoryItem(it, viewModelWrapper) }
    }
}

data class TaskData(
    val title: String,
    val description: String,
    val progress: Int,
    val isFinished: Int
)

@Composable
fun CategoryItem(value: TaskStats, viewModelWrapper: ViewModelWrapper<ProfileViewModel>) {
    val taskFinished = listOf<TaskData>(
        TaskData("Алфавит", "Изучение алфавита", value.alphabet, 0),
        TaskData("Математика", "Изучение алфавита", value.mathematics, 3),
        TaskData("Логика", "Изучение алфавита", value.logic, 3),
        TaskData("Цифры", "Изучение алфавита", value.numbers, 3),
        TaskData("Формы", "Изучение алфавита", value.figures, 3),
        TaskData("Цвета", "Изучение алфавита", value.colors, 3),
        TaskData("Английский", "Изучение алфавита", value.english, 0),
    )

    LazyColumn {


        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clip(
                    RoundedCornerShape(15.dp)
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 50.dp)
                        .fillMaxWidth()
                ) {

                    IconButton(
                        onClick = { viewModelWrapper.viewModel.onSettingsClick() },
                        modifier = Modifier
                            .size(25.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings),
                            contentDescription = "",
                            tint = Color(0xFF474992)
                        )
                    }
                        Image(
                            modifier = Modifier
                                .size(75.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFC7C7C7),
                                    shape = CircleShape
                                ).clip(CircleShape)
                                ,
                            painter = painterResource(id = R.drawable.avatarka),
                            contentDescription = "",
                        )

//            Image(
//                painter = painterResource(id = R.drawable.ic_avatarka), contentDescription = "",
//                modifier = Modifier
//                    .size(80.dp)
//                    .border(width = 2.dp, shape = CircleShape, color = Color(0xFFC7C7C7))
//            )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_notifications),
                        contentDescription = "",
                        modifier = Modifier
                            .size(25.dp),
                        tint = Color(0xFF474992)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text(
                        text = viewModelWrapper.viewModel.getUser().name, style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF474992)
                        )
                    )
                    Text(
                        text = "${viewModelWrapper.viewModel.getUser().level} уровень",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF474992)
                        ),
                        modifier = Modifier.padding(top = 3.dp, bottom = 20.dp)
                    )
                }
            }
        }


        item {
            Text(
                text = "Завершено", style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF474992)
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        items(items = taskFinished) { item ->
            //TODO Сделать чтобы был вывод пустых элементов
//            if{
//                EmptyItem()
//                Log.e("asd", "askdj")
//            }
            if (item.progress >= item.isFinished) {
                Column(
                    Modifier
                        .padding(vertical = 20.dp)
                        .padding(start = 16.dp, end = 16.dp, top = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    FinishedItem(
                        item.title,
                        item.description,
                        item.progress,
                        item.progress >= item.isFinished
                    )
                }
            }
        }

        item {
            Text(
                text = "В процессе", style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF474992)
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        items(items = taskFinished) { item ->
            if (item.progress < item.isFinished) {
                Column(
                    Modifier
                        .padding(vertical = 20.dp)
                        .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                ) {
                    FinishedItem(
                        item.title,
                        item.description,
                        item.progress,
                        item.progress >= item.isFinished
                    )
                }
            }
//            if (taskFinished.isEmpty()){
//                EmptyItem()
//            }
        }
    }
}

@Composable
fun FinishedItem(title: String, description: String, progress: Int, isFinished: Boolean) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Row(
            modifier = Modifier
                .width(330.dp)
                .height(130.dp)
                .border(width = 2.dp, color = Color(0xFFD9D9D9), shape = RoundedCornerShape(15.dp))
        ) {
            Image(
                painter = painterResource(id = if (isFinished) R.drawable.ic_finished else R.drawable.ic_in_proccess),
                contentDescription = "",
                modifier = Modifier
                    .size(130.dp)
                    .padding(top = 19.dp, bottom = 18.dp, start = 9.dp, end = 24.dp)
            )

            Column(Modifier.padding(top = 18.dp)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF474992)
                        ),
                    )
                    Text(
                        text = "$progress%", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF474992)
                        )
                    )
                }
                Text(
                    text = description, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFD9D9D9)
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Box(
                    modifier = Modifier
                        .padding(top = 26.dp, bottom = 26.dp, end = 35.dp)
                        .width(167.dp)
                        .height(14.dp),
                )
            }
        }
    }
}

@Composable
fun EmptyItem() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .width(330.dp)
                .height(130.dp)
                .border(width = 2.dp, color = Color(0xFFD9D9D9), shape = RoundedCornerShape(15.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_finished), contentDescription = "",
                modifier = Modifier
                    .size(130.dp)
                    .padding(top = 19.dp, bottom = 18.dp, start = 9.dp, end = 24.dp)
            )

            Column(Modifier.padding(top = 18.dp)) {
                Text(
                    text = "Нет задач",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF474992)
                    ),
                )
            }
        }
    }
}
