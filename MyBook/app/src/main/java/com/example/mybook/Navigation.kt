package com.example.mybook

import android.content.Context
import android.content.Intent

class Navigation {
    fun nav(packageContext: Context, activityClass: Class<*>) {
        Intent(packageContext, activityClass).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            packageContext.startActivity(it)
        }
    }
}