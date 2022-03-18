package com.panvova.conductor_example.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
  override fun doWork(): Result {
    Log.d("WORK_MANAGER", "start")
    TimeUnit.SECONDS.sleep(2)
    Log.d("WORK_MANAGER", "medium")
    TimeUnit.SECONDS.sleep(2)
    Log.d("WORK_MANAGER", "end")
    return Result.success()
  }
}