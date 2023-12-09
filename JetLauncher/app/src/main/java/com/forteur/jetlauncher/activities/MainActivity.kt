package com.forteur.jetlauncher.activities

import android.content.pm.ApplicationInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.forteur.jetlauncher.activities.mainactivity.viewmodels.DebugScreenViewModel
import com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables.DebugScreenComposable
import com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables.getInstalledApps
import com.forteur.jetlauncher.ui.theme.JetLauncherTheme

class MainActivity : ComponentActivity() {

    lateinit var debugScreenViewModel: DebugScreenViewModel

    var appsLiveData = MutableList<ApplicationInfo>(0) { ApplicationInfo() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        debugScreenViewModel = DebugScreenViewModel(this)

        setContent {
            JetLauncherTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    DebugScreenComposable(debugScreenViewModel, appsLiveData)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        appsLiveData = getInstalledApps(packageManager)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetLauncherTheme {
        Greeting("Android")
    }
}