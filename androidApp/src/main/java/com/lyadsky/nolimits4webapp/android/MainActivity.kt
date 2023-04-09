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
import com.lyadsky.nolimits4webapp.data.AppDatabaseRepostitory
import org.koin.android.ext.android.inject
import java.util.*

class MainActivity : ComponentActivity() {

    private val rootNavigation: AndroidNavigator by inject()
    private val userDao: AppDatabaseRepostitory by inject()

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

        textToSpeech.speak("asdpkapsodkapsodk", TextToSpeech.QUEUE_FLUSH, null)

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
            val user = userDao.getUser()
            if (user != null && user.name.isNotEmpty())
                ScreenRoute.Main
            else
                ScreenRoute.Register
        } catch (e: Throwable) {
            ScreenRoute.Register
        }
    }
}