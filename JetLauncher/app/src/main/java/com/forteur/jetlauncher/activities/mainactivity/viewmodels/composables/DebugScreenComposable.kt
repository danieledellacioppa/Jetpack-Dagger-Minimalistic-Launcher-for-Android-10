package com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables

import android.content.pm.ApplicationInfo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.forteur.jetlauncher.activities.mainactivity.viewmodels.DebugScreenViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DebugScreenComposable(viewModel: DebugScreenViewModel, appsLiveData: MutableList<ApplicationInfo>) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()


    Scaffold( floatingActionButton = { DebugFloatingActionButton(coroutineScope, sheetState) } )
    {
            innerPadding -> Box(modifier = Modifier.detectSwipeUpToShowSheet(coroutineScope, sheetState, innerPadding))
            {

            MyScreenWithModalBottomSheet(
                sheetState = sheetState,
                sheetContent = {
                    AppList(viewModel.packageManager, appsLiveData)
                },
                content = {
                    Box(modifier = Modifier.fillMaxSize()) {

                    }
                }
            )
           }
    }
}










