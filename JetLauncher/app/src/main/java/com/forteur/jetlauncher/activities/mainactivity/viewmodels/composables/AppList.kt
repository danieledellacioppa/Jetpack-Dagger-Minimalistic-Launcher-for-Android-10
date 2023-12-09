package com.forteur.jetlauncher.activities.mainactivity.viewmodels.composables

import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable


@Composable
fun AppList(packageManager: PackageManager, appsLiveData: MutableList<ApplicationInfo>) {
    val apps = getInstalledApps(packageManager)

    LazyVerticalGrid(GridCells.Fixed(5)) {
        items(apps) { app ->
            AppItem(app, packageManager)
        }
    }
}

fun getInstalledApps(packageManager: PackageManager): MutableList<ApplicationInfo> {
//    return packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
    val mainIntent = Intent(Intent.ACTION_MAIN, null)
    mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
    val launchableApps = packageManager.queryIntentActivities(mainIntent, 0)
    val appList = mutableListOf<ApplicationInfo>()
    for (resolveInfo in launchableApps) {
        val appInfo = resolveInfo.activityInfo.applicationInfo
        appList.add(appInfo)
    }
    return appList

}