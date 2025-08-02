package com.raaveinm.learning.ui

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.raaveinm.learning.R

fun sampleNotification(context: Context){
    val notificationBuilder = NotificationCompat.Builder(
        context,
        CHANNEL_ID
    )
        .setSmallIcon(R.drawable._0250421_224804)
        .setWhen(10000)
        .setLargeIcon(BitmapFactory.decodeResource(
            context.resources,
            R.drawable._0250421_224804)
        )
        .setContentTitle("Sample Notification")
        .setContentText("This is a sample notification")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setStyle(NotificationCompat.BigTextStyle()
            .bigText("This is a sample notification, it has been expanded"))
        .setStyle(NotificationCompat.BigPictureStyle()
            .bigPicture(BitmapFactory.decodeResource(
                context.resources,
                R.drawable._0250421_224804))
        )
        .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
        .setPublicVersion(
            NotificationCompat.Builder( context, CHANNEL_ID)
                .setContentTitle("Sample Notification")
                .setContentText("public notification version")
                .build()
        )
        .build()
}

fun showNotification(context: Context) {
    val notificationManager =
        getSystemService(
            context, NotificationManager::class.java
        ) as NotificationManager

    val notificationBuilder =
        NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable._0250618_102256)
            .setContentTitle("Sample Notification")
            .setContentText("This is a sample notification!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_RECOMMENDATION)

    notificationManager.notify(12, notificationBuilder.build())
}