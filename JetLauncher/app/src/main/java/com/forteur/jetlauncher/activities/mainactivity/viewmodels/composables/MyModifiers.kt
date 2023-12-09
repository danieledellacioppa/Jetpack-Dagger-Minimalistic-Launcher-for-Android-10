package com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables

import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
* In Jetpack Compose, Modifier is a special class designed to be used through a pattern of extension functions, rather than through direct extension of the class itself. This means that you cannot extend Modifier as a normal class. However, you can achieve a similar result by creating an extension function on Modifier that groups multiple modifiers, as I thought initially with detectSwipeUpToShowSheet().
* The reason for this design is that Modifier in Jetpack Compose is implemented as an immutable list of modification elements, where each extension function returns a new instance of Modifier with an additional element added to the list. This approach maintains purity and immutability, which are key concepts in Compose!
* Here's how you can create an extension function that combines multiple behaviors into a single Modifier:
 * @param coroutineScope CoroutineScope
 * @param sheetState ModalBottomSheetState
 * @param innerPadding PaddingValues
 * @return Modifier
 * @see <a href="https://developer.android.com/jetpack/compose/modifiers">Modifiers</a>
*/

@OptIn(ExperimentalMaterialApi::class)
fun Modifier.detectSwipeUpToShowSheet(
    coroutineScope: CoroutineScope,
    sheetState: ModalBottomSheetState,
    innerPadding: PaddingValues
): Modifier {
    return this
        .padding(innerPadding)
        .pointerInput(Unit) {
            detectVerticalDragGestures { _, dragAmount ->
                if (dragAmount < 0) { // Controlla la direzione della gesture
                    coroutineScope.launch {
                        sheetState.show()
                    }
                }
            }
        }
}