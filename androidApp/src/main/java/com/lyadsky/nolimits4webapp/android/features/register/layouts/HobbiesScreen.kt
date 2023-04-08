package com.lyadsky.nolimits4webapp.android.features.register.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.LocalColors
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.di.ViewModelWrapper
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.common.user_data.User
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import org.koin.androidx.compose.get

@Composable
fun HobbiesScreen(
    viewModelWrapper: ViewModelWrapper<RegisterViewModel>,
    userData: UserDataManager = get()
) {

    val isHorizontal = LocalConfiguration.current.orientation == 2

    val state = viewModelWrapper.viewModel.state.collectAsState()

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
            columns = GridCells.Fixed(if (isHorizontal) 4 else 2),
            contentPadding = PaddingValues(bottom = 40.dp, start = 16.dp, end = 16.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

            ) {
            //TODO
            items(count = 20) {
                GridItems()
            }

            item(span = { GridItemSpan(if (isHorizontal) 4 else 2) }) {
                CommonButton(text = "Создать") {
                    userData.saveAuthData(
                        User(
                            state.value.name,
                            state.value.age,
                            state.value.isMale ?: true
                        )
                    )
                    viewModelWrapper.viewModel.onNextClick()
                }
            }
        }
    }
}

@Composable
fun GridItems() {
    Column(
        modifier = Modifier
            .size(
                156.dp,
                178.dp
            )
            .shadow(4.dp, RoundedCornerShape(15.dp))
            .background(Color.White, RoundedCornerShape(15.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(126.dp),
            painter = painterResource(id = R.drawable.monkey_clown),
            contentDescription = ""
        )
        Text(
            text = "Алфавит",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = LocalColors.current.color6
        )
    }
}
