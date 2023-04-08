package com.lyadsky.nolimits4webapp.android.features.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyadsky.nolimits4webapp.android.features.settings.layouts.SettingsLayout

@Composable
fun SettingsScreen() {
    Column(Modifier.fillMaxSize()) {
        SettingsLayout()
    }
}
