package com.example.platform_min_50

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.widget.Button
import android.annotation.SuppressLint
import java.io.File

class MainActivity : AppCompatActivity() {
    @SuppressLint("InvalidWakeLockTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        val wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakelockTag")
        wakeLock.acquire()

        klasor_olustur()

        val is_baslatma_butonu = findViewById<Button>(R.id.analiz_baslatma_butonu)
        is_baslatma_butonu.setOnClickListener {
            val intent = Intent(this, is_parcacigi_baslatma::class.java)
            startActivity(intent)}
    }

    fun klasor_olustur(){
        val dosyaolustur_input = File(getExternalFilesDir(null),"input")
        val dosyaolustur_output = File(getExternalFilesDir(null),"output")
        dosyaolustur_output.mkdirs()
        dosyaolustur_input.mkdirs()}

    override fun onDestroy() {
        super.onDestroy()

    }
}