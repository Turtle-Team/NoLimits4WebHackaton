package com.lyadsky.nolimits4webapp.android.features.tasks.alphabet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyadsky.nolimits4webapp.android.features.tasks.alphabet.layouts.AlphabetLayout

@Composable
fun AlphabetScreen() {
    Column(Modifier.fillMaxSize()) {
        AlphabetLayout()
    }
}
