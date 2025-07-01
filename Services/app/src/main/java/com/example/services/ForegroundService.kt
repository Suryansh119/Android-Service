package com.example.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class ForegroundService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("AppServices", "Created")
        createNotificationChannel()
        val notification= NotificationCompat.Builder(this,"Foreground Channel")
            .setContentTitle("AppServices")
            .setContentText("Service Running")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()

        startForeground(1,notification)

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
        return START_STICKY


    }


    private fun createNotificationChannel(){

        val channel= NotificationChannel("Foreground Channel","Foreground Channel",NotificationManager.IMPORTANCE_DEFAULT)
        val manager=getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)


    }



}