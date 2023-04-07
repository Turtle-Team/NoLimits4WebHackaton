package com.lyadsky.nolimits4webapp.android.features.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lyadsky.nolimits4webapp.android.features.views.bars.StageBar
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterScreen() {
    LazyColumn(
        Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 50.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        stickyHeader {
            StageBar(number = 1)
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically)
            ) {
                CommonEditText(title = "Имя пользователя", onValueChanged = {})

                CommonEditText(title = "Электронная почта", onValueChanged = {})

                CommonEditText(title = "Пароль", onValueChanged = {})
            }
        }
        item {
            CommonButton(text = "Дальше") {

            }
        }

    }
}
