package com.lyadsky.nolimits4webapp.android.features.tasks.numbers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyadsky.nolimits4webapp.android.features.tasks.numbers.layout.NumberLayout

@Composable
fun NumberScreen() {
    Column (Modifier.fillMaxSize()){
        NumberLayout()
    }
}
