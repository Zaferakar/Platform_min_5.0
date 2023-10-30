package com.example.platform_min_50

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform



class is_parcacigi(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        Log.v("zafer", "python_analizi_baslatildi")

        gorev()


        return Result.success()
    }

    private fun gorev() {

        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(applicationContext))
        }
        val py = Python.getInstance()

        val python_main = py.getModule("main")
        val log = python_main["analiz_batis_belirtec"]
        Log.v("zafer", log.toString())



        /*for (i in 1..10){
            Thread.sleep(1000)
            println(i)
        }*/
    }}
