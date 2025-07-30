package com.raaveinm.learning

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.work.ListenableWorker
import androidx.work.testing.TestListenableWorkerBuilder
import com.raaveinm.learning.workers.SecondWorker
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

@Suppress("DEPRECATION")
class WorkerInstrumentationTest {
    private lateinit var context: Context

    @Before fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }


    @Test
    fun testSecondWorker_returnsSuccess() {
        // Build the worker
        val worker = TestListenableWorkerBuilder<SecondWorker>(context).build()

        // Run the worker
        runBlocking {
            val result = worker.doWork()

            // Assert that the worker succeeded
            assertThat(result, `is`(ListenableWorker.Result.success()))
        }
    }
}