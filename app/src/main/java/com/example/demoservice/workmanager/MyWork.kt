package com.example.demoservice.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWork(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        return Result.success()
    }
}