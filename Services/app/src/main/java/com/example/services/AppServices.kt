package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class AppServices : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("AppServices", "Created")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("AppServices", "Service Started")
        thread(start = true) {
            while (true){
                Log.d("AppServices", "Service Running")
                Thread.sleep(1000)

            }
        }
        return super.onStartCommand(intent, flags, startId)


    }

}