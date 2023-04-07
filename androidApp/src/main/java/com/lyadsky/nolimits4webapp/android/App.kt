package com.lyadsky.nolimits4webapp.android

import android.app.Application
import com.lyadsky.nolimits4webapp.android.di.androidModule
import com.lyadsky.nolimits4webapp.common.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            allowOverride(true)
            modules(androidModule())
        }
    }
}
