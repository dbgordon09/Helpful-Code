package com.avochoc.drugreaction.utilities

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.View
import com.avochoc.drugreaction.R

object StatusBarHelper {
    //Making the Status Bar Transparent and Notifications Dark
    fun makeTransparent(activity: Activity) {
        activity.window.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                statusBarColor = Color.TRANSPARENT
            } else
                statusBarColor = ContextCompat.getColor(activity, R.color.colorPrimary)
        }
    }
}