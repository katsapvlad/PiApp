package com.example.log_test

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import kotlin.math.PI
import kotlin.math.round



class PiService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val in_key = "key"
        var n: Double = intent.getDoubleExtra(in_key, 1.0)
        piService(n)
        return super.onStartCommand(intent, flags, startId)
    }

    private fun piService (n:Double){
        var message :Intent = Intent()
        val temp = (PI*(Math.pow(10.0, n)))
        val res = round(temp)/Math.pow(10.0, n)
        message.action = "PI"
        message.putExtra("res", res)
        sendBroadcast(message)
        stopSelf()
    }


}
