package com.iteo.androidcleanuitests.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iteo.androidcleanuitests.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        list.adapter = ListAdapter()
    }
}
