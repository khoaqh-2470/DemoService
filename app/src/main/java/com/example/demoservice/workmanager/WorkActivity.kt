package com.example.demoservice.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.demoservice.R
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        buttonMyWork.setOnClickListener {
            val myConstraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true) // check < 10%
                .build()

            val myWork = OneTimeWorkRequest.Builder(MyWork::class.java)
                .setConstraints(myConstraints)
//                .setInitialDelay(1000, TimeUnit.MILLISECONDS)
                .build()

            WorkManager
                .getInstance(this)
                .enqueue(myWork)

        }

        buttonStop.setOnClickListener {

            val workA = OneTimeWorkRequest.Builder(WorkA::class.java).build()
            val workB = OneTimeWorkRequest.Builder(WorkB::class.java).build()
            val workC = OneTimeWorkRequest.Builder(WorkC::class.java).build()

            WorkManager
                .getInstance(this)
                .beginWith(listOf(workA))
                .then(workB)
                .then(workC)
                .enqueue()
        }
    }
}