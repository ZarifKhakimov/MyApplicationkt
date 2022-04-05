package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, Second::class.java)
            startActivity(intent)
            finish()
        }, 3000)
        initViews()
    }
    private fun initViews() {
        val twitter = findViewById<Button>(R.id.twtt)
        twitter.setOnClickListener { openNextPage()
            fun onClick(view: View?) {
                openNextPage()
            }

        }
    }
    private fun openNextPage() {
        val intent = Intent(this, Second::class.java)
        startActivity(intent)
    }
}