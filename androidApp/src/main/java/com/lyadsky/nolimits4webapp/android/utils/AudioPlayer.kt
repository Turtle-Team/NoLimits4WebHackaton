package com.lyadsky.nolimits4webapp.android.utils

import android.content.Context
import android.media.MediaPlayer
import android.speech.tts.TextToSpeech


fun playAudio(context: Context, rawId: Int) {
    val mediaPlayer = MediaPlayer.create(context, rawId)
    mediaPlayer.start()
}
