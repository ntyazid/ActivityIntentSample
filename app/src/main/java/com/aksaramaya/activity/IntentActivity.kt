package com.aksaramaya.activity

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent.*


class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val name = intent.extras?.getString("name")

        btn_open_google.setOnClickListener {
            openGoogle()
        }

        btn_whats_app.setOnClickListener {
            openWhatsApp("+62800000000000")
        }

        btn_display_contact.setOnClickListener {
            openContactList()
        }

        btn_dial_phone.setOnClickListener {
            openDialPhoneCall()
        }

        btn_broadcast_message.setOnClickListener {
            broadcastMessage()
        }

        btn_start_service.setOnClickListener {
            startIntentService()
        }
    }

    private fun openGoogle() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/"))
        startActivity(intent)
    }

    private fun openWhatsApp(phoneNumber: String) {
        val url = "https://api.whatsapp.com/send?phone=$phoneNumber"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun openContactList() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
        startActivity(intent)
    }

    private fun openDialPhoneCall() {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"))
        startActivity(intent)
    }

    /*Broadcast receiver*/
    private fun broadcastMessage() {
        val intent = Intent("com.amikom.SOME_ACTION")
        sendBroadcast(intent)
    }

    private var receiver: ConnectionReceiver? = null
    var intentFilter: IntentFilter? = null

    override fun onResume() {
        receiver = ConnectionReceiver()
        intentFilter = IntentFilter()
        intentFilter?.addAction("com.amikom.SOME_ACTION")
        intentFilter?.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver, intentFilter);
        super.onResume()
    }

    override fun onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy()
    }

    /*Intent service*/
    private fun startIntentService() {
        val intent = Intent(this, SampleIntentService::class.java)
        intent.putExtra("value", "yes")
        startService(intent)
    }
}