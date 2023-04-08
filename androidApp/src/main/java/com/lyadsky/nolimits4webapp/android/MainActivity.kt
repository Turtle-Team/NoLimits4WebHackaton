package com.lyadsky.nolimits4webapp.android

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.lyadsky.nolimits4webapp.android.features.mainNavigation.MainNavigationScreen
import com.lyadsky.nolimits4webapp.android.navigation.AndroidNavigator
import com.lyadsky.nolimits4webapp.common.navigation.ScreenRoute
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import org.koin.android.ext.android.inject
import java.util.*

class MainActivity : ComponentActivity() {

    private val rootNavigation: AndroidNavigator by inject()
    private val userData: UserDataManager by inject()

    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val startDestination = defineStartDestination()

        val local = Locale("RU")
        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.language = local
            }
        }

        setContent {
            val navController = rememberNavController()
            rootNavigation.navController = navController
            AppTheme {
                MainNavigationScreen(navController, startDestination = startDestination)
            }
        }
    }

    fun speak(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.stop()
        textToSpeech.shutdown()
    }

    private fun defineStartDestination(): ScreenRoute {
        return try {
            userData.getUserData()
            ScreenRoute.Main
        } catch (e: Throwable) {
            ScreenRoute.Register
        }
    }
}