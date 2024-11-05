package com.example.marvel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

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