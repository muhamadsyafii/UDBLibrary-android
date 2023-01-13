package com.ransyadev.udblibrary

import android.app.Application

class UdbLibraryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: UdbLibraryApp
            private set
    }
}
