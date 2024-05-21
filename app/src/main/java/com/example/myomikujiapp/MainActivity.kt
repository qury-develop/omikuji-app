package com.example.myomikujiapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myomikujiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.getOmikujiButton.setOnClickListener {
            val result = arrayOf("大吉", "中吉", "小吉", "吉", "凶")

            val range = (0..<result.count())
            val n = range.random()

            if (n == 0) {
                binding.resultTextView.setTextColor(Color.RED)
            } else {
                binding.resultTextView.setTextColor(Color.parseColor("#808080"))
            }

            binding.resultTextView.text = result[n]

        }
    }
}