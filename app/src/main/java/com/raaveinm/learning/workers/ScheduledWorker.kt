package com.raaveinm.learning.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ScheduledWorker(context: Context, params: WorkerParameters)
    : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val intValue = inputData.getInt("int_value", 0)
        val stringValue = inputData.getString("string_value")

        return withContext(Dispatchers.IO){
            return@withContext try {
                makeStatusNotification(
                    "device is $stringValue at $intValue minutes",
                    applicationContext
                )
                delay(5000)
                val res = workDataOf("int_value" to intValue + 20)
                Result.success(res)
            } catch (e: Throwable) {
                e.printStackTrace()
                Result.failure()
            }
        }
    }
}