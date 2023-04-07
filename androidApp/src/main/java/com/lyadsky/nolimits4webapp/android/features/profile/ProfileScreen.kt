package com.lyadsky.nolimits4webapp.android.features.profile

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ProfileScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Text(text = "profile")
    }
}
