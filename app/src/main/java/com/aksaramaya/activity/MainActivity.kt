package com.aksaramaya.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*set onClick listener pada button*/
        btn_sample.setOnClickListener {
            /*Menggunakan intent untuk memanggil activity lain*/

            val intent = Intent(this, IntentActivity::class.java)
            intent.putExtra("name", "Yazid")
            startActivity(intent)

        }

        btn_close.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("ondestroy")
    }
}