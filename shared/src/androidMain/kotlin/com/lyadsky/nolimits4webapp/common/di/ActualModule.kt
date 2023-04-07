package com.lyadsky.nolimits4webapp.common.di

import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
//        AppDatabase(AndroidSqliteDriver(NoteDatabase.Schema, get(), "AppDatabase.db"))
    }
}
