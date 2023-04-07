package com.lyadsky.nolimits4webapp.common.di

import com.lyadsky.nolimits4webapp.common.user_data.NativeUserDataManagerImpl
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import kotlinx.serialization.json.Json
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
//        AppDatabase(AndroidSqliteDriver(NoteDatabase.Schema, get(), "AppDatabase.db"))
    }

    single<UserDataManager> {
        NativeUserDataManagerImpl(get())
    }

    factory<Json> {
        Json {
            ignoreUnknownKeys = true
        }
    }
}
