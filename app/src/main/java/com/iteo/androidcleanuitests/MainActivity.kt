package com.iteo.androidcleanuitests

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iteo.androidcleanuitests.list.ListActivity
import com.iteo.androidcleanuitests.rotatingimage.RotatingImageActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionSingleChange.setOnClickListener { goTo(SingleChangeActivity::class) }
        actionList.setOnClickListener { goTo(ListActivity::class) }
        actionCustomView.setOnClickListener { goTo(RotatingImageActivity::class) }
        actionManySteps.setOnClickListener { goTo(ManyStepsActivity::class) }
        actionWithResult.setOnClickListener { goTo(ResultActivity::class) }

    }

    private fun goTo(kClass: KClass<out Activity>) {
        startActivity(Intent(this, kClass.java))
    }

}
