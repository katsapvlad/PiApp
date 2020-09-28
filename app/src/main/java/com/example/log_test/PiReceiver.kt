package com.example.log_test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class PiReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val tag = "KatsapUA_OnReceiver"
        val res :Double = intent.getDoubleExtra("res", 1.0)
        Toast.makeText(context,"$res", Toast.LENGTH_LONG).show()
        Log.d(tag, "res is $res")
    }
}
