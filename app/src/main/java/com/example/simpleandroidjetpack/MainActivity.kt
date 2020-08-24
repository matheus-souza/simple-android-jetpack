package com.example.simpleandroidjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleandroidjetpack.ui.start.StartFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.myContainer, StartFragment.newInstance())
            .commit()
    }
}