package com.lyadsky.nolimits4webapp.android.features.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyadsky.nolimits4webapp.android.features.catalog.layouts.CatalogLayout

@Composable
fun CatalogScreen() {
    Column(Modifier.fillMaxSize()) {
        CatalogLayout()
    }
}
