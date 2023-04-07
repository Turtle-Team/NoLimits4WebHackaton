package com.lyadsky.nolimits4webapp.android.features.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Text(text = "main")
    }
}
