package com.lyadsky.nolimits4webapp.android.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class TextToSpeechWrapper(context: Context) {

    private val textToSpeech: TextToSpeech = TextToSpeech(context) { status ->
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech.language = Locale.getDefault()
        }
    }

    fun speak(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun shutdown() {
        textToSpeech.stop()
        textToSpeech.shutdown()
    }
}
