package com.supranet.magislauncher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            launchMgstv()
        }, 5000)
    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed({
            launchMgstv()
        }, 5000)
    }

    private fun launchMgstv() {
        val launchIntent = packageManager.getLaunchIntentForPackage("com.android.mgstv")
        if (launchIntent != null) {
            startActivity(launchIntent)
            finish()
        } else {
            Toast.makeText(this, "La aplicación mgstv no está instalada", Toast.LENGTH_LONG).show()
        }
    }
}