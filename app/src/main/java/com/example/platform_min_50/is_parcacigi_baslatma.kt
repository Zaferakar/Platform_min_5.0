package com.example.platform_min_50
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager

import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager


class is_parcacigi_baslatma : AppCompatActivity() {
    @SuppressLint("InvalidWakeLockTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.is_parcacigi_baslatma)

        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        val wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakelockTag")
        wakeLock.acquire()
        val uploadWorkRequest = OneTimeWorkRequestBuilder<is_parcacigi>().build()
        WorkManager.getInstance().enqueue(uploadWorkRequest)



    }

    override fun onDestroy() {
        super.onDestroy()

    }
}