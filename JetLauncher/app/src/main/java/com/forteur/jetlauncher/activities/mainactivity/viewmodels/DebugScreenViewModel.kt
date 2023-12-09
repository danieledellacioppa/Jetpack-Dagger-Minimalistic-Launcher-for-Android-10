package com.forteur.jetlauncher.activities.mainactivity.viewmodels

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class DebugScreenViewModel(activity: ComponentActivity) {

    val context: Context
        get() {
            return activity.applicationContext
        }

    var packageManager: PackageManager

    var activity: ComponentActivity
    init {
        this.activity = activity
        this.packageManager = activity.packageManager
    }

}






