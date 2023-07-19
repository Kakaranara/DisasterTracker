package com.kocci.disastertracker.util.extension

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.showToast(message: String, isLongToast: Boolean = false) {
    if (isLongToast)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    else
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String, isLongToast: Boolean = false) {
    activity?.let { activityContext ->
        if (isLongToast) {
            Toast.makeText(activityContext, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(activityContext, message, Toast.LENGTH_SHORT).show()
        }
    }
}