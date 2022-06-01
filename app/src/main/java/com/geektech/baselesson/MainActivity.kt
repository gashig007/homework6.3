package com.geektech.baselesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.baselesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    val binding by viewBinding(ActivityMainBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}