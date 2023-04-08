package com.lyadsky.nolimits4webapp.android.utils

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AudioPlayer(rawId: Int) {
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, rawId) }
    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                if (!isPlaying) {
                    mediaPlayer.start()
                    isPlaying = true
                } else {
                    mediaPlayer.pause()
                    isPlaying = false
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(if (isPlaying) "Pause" else "Play")
        }
    }
}
