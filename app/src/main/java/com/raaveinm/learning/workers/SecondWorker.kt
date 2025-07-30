package com.raaveinm.learning.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class SecondWorker(context: Context, params: WorkerParameters)
    : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO){
            return@withContext try {
                delay(4_500)
                Result.success()
            } catch (e: Throwable) {
                e.printStackTrace()
                Result.failure()
            }
        }
    }
}