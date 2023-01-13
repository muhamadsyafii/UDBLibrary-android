package com.ransyadev.udblibrary.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ransyadev.udblibrary.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.ivBack.setOnClickListener { finish() }
    }
}
