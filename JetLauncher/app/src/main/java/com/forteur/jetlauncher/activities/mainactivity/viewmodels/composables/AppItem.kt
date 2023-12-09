package com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap

@Composable
fun AppItem(app: ApplicationInfo, packageManager: PackageManager) {
    val context = LocalContext.current

    Card (
        colors= androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
        ),
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .clickable {
                val launchIntent = packageManager.getLaunchIntentForPackage(app.packageName)
                if (launchIntent != null) {
                    context.startActivity(launchIntent)
                }
            }
            .background( Color.Transparent, shape = RoundedCornerShape(6.dp) ),
        shape = MaterialTheme.shapes.medium,
    ) {
        Box(
        modifier = Modifier
            .fillMaxSize()
        ){
            val icon = remember { packageManager.getApplicationIcon(app.packageName) }
            Image(
                bitmap = icon.toBitmap().asImageBitmap(),
                modifier= Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .align(Alignment.TopCenter),
                contentDescription = null,
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = packageManager.getApplicationLabel(app).toString(),
                modifier= Modifier
                    .padding(3.dp)
                    .align(Alignment.BottomCenter),
                style =  TextStyle(
                    color = Color.White,
                    fontSize = 11.sp,
                    fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                    lineHeight = 10.sp,
                    shadow= Shadow(
                        color = Color.Black,
                        offset = Offset(0f, 0f),
                        blurRadius = 4f
                    )
                )
            )

        }
    }

}