package com.lyadsky.nolimits4webapp.common.user_data

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class NativeUserDataManagerImpl(private val context: Context) : KoinComponent,UserDataManager {

    companion object {
        private const val PREFS_NAME = "USERDATAPREFS"
        private const val USER_DATA = "USERDATA"

        private const val def_val = "" //TODO поменять на "" когда будет нормальная авторизация
    }

    private val json: Json by inject()
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveAuthData(encodedUserData: String) {
        prefs.edit().putString(USER_DATA, encodedUserData).apply()
    }

    override fun getUserData(): String {

        //TODO когда будет модель пользователя заменить String на этот дата класс
        val encodedData = prefs.getString(USER_DATA, def_val)
//        json.decodeFromString</*TODO*/>(encodedData)
        return encodedData ?: def_val
    }

    override fun clearData() {
        prefs.edit().clear().apply()
    }
}

actual interface NativeUserData {

    fun saveAuthData(encodedUserData: String)
}