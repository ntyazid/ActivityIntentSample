package com.aksaramaya.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ConnectionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals("com.amikom.SOME_ACTION"))
            Toast.makeText(context, "SOME_ACTION is received", Toast.LENGTH_LONG).show()
        else {
            Toast.makeText(context, "AIRPLANE MODE CHANGED is received", Toast.LENGTH_LONG).show()
        }
    }
}