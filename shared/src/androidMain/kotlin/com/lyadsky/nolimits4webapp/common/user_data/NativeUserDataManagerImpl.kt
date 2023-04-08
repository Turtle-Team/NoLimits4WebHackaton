package com.lyadsky.nolimits4webapp.common.user_data

import android.content.Context
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class NativeUserDataManagerImpl(private val context: Context) : KoinComponent,
    UserDataManager {

    companion object {
        private const val PREFS_NAME = "USERDATAPREFS"
        private const val USER_DATA = "USERDATA"

        private const val def_val = ""
    }

    private val json: Json by inject()
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveAuthData(user: User) {
        prefs.edit().putString(USER_DATA, json.encodeToString(User.serializer(), user)).commit()
    }

    override fun getUserData(): User {

        //TODO когда будет модель пользователя заменить String на этот дата класс
        val encodedData = prefs.getString(USER_DATA, def_val)
        return json.decodeFromString<User>(User.serializer(), encodedData ?: def_val)

    }

    override fun clearData() {
        prefs.edit().putString(USER_DATA, def_val).commit()
    }
}


actual interface NativeUserData {

    fun saveAuthData(user: User)
}
