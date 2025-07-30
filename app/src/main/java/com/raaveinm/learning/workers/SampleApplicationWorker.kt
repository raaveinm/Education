package com.raaveinm.learning.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

private const val TAG = "RRR_S"

class SampleApplicationWorker(context: Context, params: WorkerParameters)
    : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val intValue = inputData.getInt("int_value", 0)
        val stringValue = inputData.getString("string_value")

        return withContext(Dispatchers.Default) {
            require((!stringValue.isNullOrBlank())){
                val msg = "String value cannot be null or blank"
                Log.e(TAG, msg)
                msg
            }
            return@withContext try {
                delay(10_000)
                Log.d(TAG, "doWork: $intValue $stringValue")
                val outputData = workDataOf(
                    "int_value" to intValue * 2,
                    "string_value" to "edited $stringValue"
                )
                Result.success(outputData)
            } catch (e: Throwable) {
                Log.e(TAG, "Error executing work", e)
                Result.failure()
            }
        }
    }
}