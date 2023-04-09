package com.lyadsky.nolimits4webapp.common.di

import com.lyadsky.database.AppDatabase
import com.lyadsky.nolimits4webapp.data.AppDatabaseRepostitory
import com.lyadsky.nolimits4webapp.data.AppDatabaseRepostitoryImpl
import com.lyadsky.nolimits4webapp.common.user_data.NativeUserDataManagerImpl
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.squareup.sqldelight.android.AndroidSqliteDriver
import kotlinx.serialization.json.Json
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        AppDatabase(AndroidSqliteDriver(AppDatabase.Schema, get(), "AppDatabase.db"))
    }

    single<UserDataManager> {
        NativeUserDataManagerImpl(get())
    }

    single<AppDatabaseRepostitory> { AppDatabaseRepostitoryImpl(get()) }

    factory<Json> {
        Json {
            ignoreUnknownKeys = true
        }
    }
}
