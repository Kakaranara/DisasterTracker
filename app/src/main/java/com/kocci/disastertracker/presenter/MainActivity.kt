package com.kocci.disastertracker.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kocci.disastertracker.databinding.ActivityMainBinding
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.reportList.observe(this) {
            when (it) {
                is Async.Error -> {
                    showToast(it.message)
                }

                Async.Loading -> {
                    showToast("Loading")
                }

                is Async.Success -> {
                    showToast(it.data.toString())
                }
            }
        }
    }
}