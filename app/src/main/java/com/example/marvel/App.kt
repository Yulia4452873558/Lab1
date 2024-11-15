package com.example.marvel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var INSTANCE: Context
    }
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}
