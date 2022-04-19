package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Quora

class Second : AppCompatActivity() {
    val TAG: String = Second::class.java.toString()

    var tv_thing: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detroit)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val quora = Quora(1.3, "Now")
            Log.d(TAG, "quora")
            tv_thing?.setText(quora.toString())
        }
    }

    fun initViews() {
        tv_thing = findViewById(R.id.tv_thing)
        val b_close = findViewById<Button>(R.id.b_close)
        b_close.setOnClickListener {
            val quora = Quora(1.6, "Big")
            backToFinish(quora)
        }
        val field = intent.getParcelableExtra<Parcelable>("field")
        Log.d(TAG, field.toString())
        tv_thing?.setText(field.toString())
    }

    fun backToFinish(field: Quora) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("quora", field)
        setResult(RESULT_OK, intent)
        detailLauncher.launch(intent)
        finish()
    }
}