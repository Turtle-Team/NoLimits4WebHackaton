package com.lyadsky.nolimits4webapp.android.features.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lyadsky.nolimits4webapp.android.features.views.buttons.CommonButton
import com.lyadsky.nolimits4webapp.android.features.views.edit_texts.CommonEditText

@Composable
fun RegisterScreen() {
    Column(Modifier.fillMaxSize().padding(top = 127.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        CommonEditText(title = "Имя пользователя")
        Divider(Modifier.padding(top = 30.dp))

        CommonEditText(title = "Электронная почта")
        Divider(Modifier.padding(top = 30.dp))

        CommonEditText(title = "Пароль")

        Divider(Modifier.padding(top = 140.dp))
        CommonButton(text = "Дальше") {
            
        }
        
    }
}
