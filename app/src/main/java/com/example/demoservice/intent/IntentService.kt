package com.example.demoservice.intent

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

class IntentService : IntentService("IntentService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.d("nnn", "onHandleIntent: ")
    }
}