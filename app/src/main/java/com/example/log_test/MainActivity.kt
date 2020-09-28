package com.example.log_test

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var count :Double = 0.0;
    val key = "key"
    val tag = "KatsapUA"
    val receiver = PiReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putDouble(key, count)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getDouble(key )
        count ++
        Log.w(tag, "counter is $count")
        startService(Intent(this,PiService::class.java).putExtra(key, count))
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(receiver, IntentFilter("PI"))
    }

    override fun onStop() {
        unregisterReceiver(receiver)
        super.onStop()

    }
}

