package com.pr7.jc_gtnbinar_appforupload.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp



lateinit var  CONTEXT:MyApp
@HiltAndroidApp
class MyApp constructor(): Application(){


    override fun onCreate() {
        super.onCreate()
        CONTEXT=this
    }
}