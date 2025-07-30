package com.raaveinm.learning.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class ThirdWorker(context: Context, params: WorkerParameters)
    : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val intValue = inputData.getInt("int_value", 0)
        val stringValue = inputData.getString("string_value")

        return withContext(Dispatchers.IO){
            return@withContext try {
                delay(4_500)
                makeStatusNotification(
                    "string is $stringValue int is $intValue ",
                    applicationContext
                )
                Log.d("RRR_T", "doWork: $intValue $stringValue")
                Result.success()
            } catch (e: Throwable) {
                e.printStackTrace()
                Result.failure()
            }
        }
    }
}