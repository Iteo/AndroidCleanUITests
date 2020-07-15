package com.iteo.androidcleanuitests

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}
