package com.example.demoservice.background

import android.app.Service
import android.content.Intent
import android.os.IBinder

class BackgroundService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}