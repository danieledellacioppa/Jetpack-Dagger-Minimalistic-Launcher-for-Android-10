package com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * MyScreenWithModalBottomSheet comes from https://www.youtube.com/watch?v=VxgWUdOKgtI&t=227s
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyScreenWithModalBottomSheet(
    sheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = sheetContent,
        sheetGesturesEnabled = true,
        sheetBackgroundColor = Color.Gray.copy(alpha = 0.85f),
        sheetShape = RoundedCornerShape(6.dp),
        scrimColor = Color.Black.copy(alpha = 0.7f),
        sheetElevation = 5.dp,
        content = content,
    )
}