package com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DebugFloatingActionButton(coroutineScope: CoroutineScope, sheetState: ModalBottomSheetState) {
    FloatingActionButton(onClick = {
        coroutineScope.launch {
            sheetState.show()
        }
    }) {
        Icon(Icons.Filled.KeyboardArrowUp, "Open Bottom Sheet")
    }
}