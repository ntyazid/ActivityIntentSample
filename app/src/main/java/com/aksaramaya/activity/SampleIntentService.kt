package com.aksaramaya.activity

import android.app.IntentService
import android.content.Intent

class SampleIntentService : IntentService("SampleIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        val value = intent?.extras?.getString("value")
        if (value.equals("yes"))
            println("yes")
        else
            println("no")
    }
}