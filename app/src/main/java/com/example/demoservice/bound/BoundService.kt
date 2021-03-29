package com.example.demoservice.bound

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class BoundService : Service() {

    private var i: Int = 0
    private val binder: IBinder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    inner class MyBinder : Binder() {
        fun getService(): BoundService = this@BoundService
    }

    fun addI(): Int {
        i += 1
        return i
    }

    fun removeI(): Int {
        i -= 1
        return i
    }
}