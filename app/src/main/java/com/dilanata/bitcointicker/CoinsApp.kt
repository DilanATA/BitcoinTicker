package com.dilanata.bitcointicker

import android.app.Application
import com.facebook.stetho.BuildConfig
import com.facebook.stetho.Stetho

class CoinsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}