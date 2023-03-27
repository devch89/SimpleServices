package com.example.simpleservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

private const val TAG = "Services"
class Services : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "onCreate: Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG, "onStartCommand: Service has started")
        Log.d(TAG, "onStartCommand: Service ${Thread.currentThread().name}")

        // Will stop Service automatically once task is finihsed
        //stopSelf()
        
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {

        Log.d(TAG, "onDestroy: Service has stopped")
        super.onDestroy()
    }
    
    
}