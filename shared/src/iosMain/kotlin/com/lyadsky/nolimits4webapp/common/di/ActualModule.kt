package com.lyadsky.nolimits4webapp.common.di

actual fun platformModule() = module {
    single {
//        NoteDatabase(AndroidSqliteDriver(NoteDatabase.Schema, get(), "AppDatabase.db"))
    }
}
