package com.example.simpleservices

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

private const val TAG = "WorkManager"

class WorkManager(context: Context, parameters: WorkerParameters) :Worker(context, parameters){

    override fun doWork(): Result {
        Log.d(TAG, "doWorkService: WorkManager is started ")
        Log.d(TAG, "doWorkService: WorkManager is on ${Thread.currentThread().name} ")

        return Result.success()
    }


}

