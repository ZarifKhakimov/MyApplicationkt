package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Field

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.toString()

    var tv_home //int LAUNCH_DETAIL = 22;
            : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val field = Field(14, "Zarifjon")
            Log.d(TAG, "field")
            tv_home?.setText(field.toString())
        }
    }

    fun initViews() {
        tv_home = findViewById(R.id.b_one)
        val b_one = findViewById<Button>(R.id.b_one)
        b_one.setOnClickListener {
            val field = Field(14, "Zarifjon")
            openDetailActivity(field)
        }
        if (intent.hasExtra("quora")) {
            val quora = intent.getParcelableExtra<Parcelable>("field")
            Log.d(TAG, quora.toString())
            tv_home?.setText(quora.toString())
        }
    }

    fun openDetailActivity(quora: Field) {
        val intent = Intent(this, Second::class.java)
        intent.putExtra("field",  quora)
        setResult(RESULT_OK, intent)
        detailLauncher.launch(intent)
    }

}