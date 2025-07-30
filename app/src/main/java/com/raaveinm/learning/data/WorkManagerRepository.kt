package com.raaveinm.learning.data

import android.annotation.SuppressLint
import androidx.lifecycle.asFlow
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.raaveinm.learning.workers.SampleApplicationWorker
import com.raaveinm.learning.workers.ScheduledWorker
import com.raaveinm.learning.workers.SecondWorker
import com.raaveinm.learning.workers.ThirdWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import java.util.concurrent.TimeUnit

class WorkManagerRepository {
    private val workManager = WorkManager.getInstance()
    private val onlyOnCharge = Constraints.Builder()
        .setRequiresCharging(true)
        .build()

    val outputWorkInfo: Flow<WorkInfo> =
        workManager.getWorkInfosByTagLiveData("SampleTag")
            .asFlow()
            .mapNotNull { if (it.isNotEmpty()) it.first() else null }

    fun startOneTimeSampleWork(){
        val workRequest = OneTimeWorkRequestBuilder<SampleApplicationWorker>()
        workRequest.setInputData(transferDataObject(4,"Читыре"))
            .setConstraints(onlyOnCharge)
            .addTag("SampleTag")
        workManager.enqueue(workRequest.build())
    }

    @SuppressLint("EnqueueWork")
    fun chainOneTimeSampleWork(){
        val continuation = workManager
            .beginWith(
                OneTimeWorkRequestBuilder<SampleApplicationWorker>()
                    .setInputData(transferDataObject(1,"none"))
                .build()
            )
            .then(OneTimeWorkRequestBuilder<SecondWorker>().build())
            .then(OneTimeWorkRequestBuilder<ThirdWorker>().build())

        continuation.enqueue()
    }

    fun startScheduledWork(){
        val periodicWorkRequest = PeriodicWorkRequestBuilder<ScheduledWorker>(
            15, TimeUnit.MINUTES
        )
            .setConstraints(onlyOnCharge)
            .setInputData(transferDataObject(0,"onCharge"))
            .build()

        workManager.enqueue(periodicWorkRequest)
    }

    @SuppressLint("EnqueueWork")
    fun beginUbiqueChain() {
        workManager
            .beginUniqueWork(
                "UniqueWorkTag",
                ExistingWorkPolicy.REPLACE,
                OneTimeWorkRequestBuilder<SampleApplicationWorker>()
                    .setInputData(transferDataObject(1, "none"))
                    .build()
            )
            .then(OneTimeWorkRequestBuilder<SecondWorker>().build())
            .then(OneTimeWorkRequestBuilder<ThirdWorker>().build())
            .enqueue()
    }

    fun cancelWork(){
        workManager.cancelUniqueWork("UniqueWorkTag")
    }

    fun transferDataObject(
        intValue: Int,
        stringValue: String
    ): Data {
        val dataBuilder = Data.Builder()
        dataBuilder.putInt("int_value", intValue)
        dataBuilder.putString("string_value", stringValue)
        return dataBuilder.build()
    }
}