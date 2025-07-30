package com.raaveinm.learning.workers

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.raaveinm.learning.R


fun makeStatusNotification(message: String, context: Context) {

    val name = "WorkerInfo"
    val description = "WorkerInfo"
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel("s", name, importance)
    channel.description = description

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

    notificationManager?.createNotificationChannel(channel)

    val builder = NotificationCompat.Builder(context, "s")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("WorkerInfo")
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVibrate(LongArray(0))

    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
    ) { return }
    NotificationManagerCompat.from(context).notify(1, builder.build())
}
