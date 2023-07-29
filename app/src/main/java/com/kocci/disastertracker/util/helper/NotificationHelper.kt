package com.kocci.disastertracker.util.helper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.kocci.disastertracker.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationHelper @Inject constructor(@ApplicationContext private val context: Context) {

    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    fun showFloodDangerNotification(floodDepth: Int) {
        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder = NotificationCompat.Builder(context, REPORT_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_warning_amber_24)
            .setContentTitle("Warning!")
            .setContentText("Highest flood depth found :$floodDepth cm.")
            .setSound(soundUri)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        notificationManager.notify(RQC_Report, builder.build())
    }


    companion object {
        const val REPORT_CHANNEL_ID = "Report_channel_id"
        private const val REPORT_CHANNEL_NAME = "Report_channel"

        //RQC stands for Request Code.
        const val RQC_Report = 1250

        fun createNotificationChannel(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationManager = context.getSystemService(NotificationManager::class.java)
                val channel = NotificationChannel(
                    REPORT_CHANNEL_ID,
                    REPORT_CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationManager.createNotificationChannel(channel)
            }

        }
    }
}