package com.example.mybook

import android.app.Activity
import android.content.Intent

class Navigation {
    fun nav(currentActivity: Activity, activityClass: Class<*>) {
        Intent(currentActivity, activityClass).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            currentActivity.startActivity(it)
            currentActivity.finish()
        }
    }
}