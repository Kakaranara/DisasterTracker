package com.kocci.disastertracker.util.helper

import android.util.Log

// easy log (debug)
object MyLogger {
    private const val TAG = "DEBUG LOG"
    fun w(msg: String) {
        Log.w(TAG, "w: $msg")
    }

    fun e(msg: String) {
        Log.e(TAG, "e: $msg")
    }
}