package com.kocci.disastertracker.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kocci.disastertracker.R
import com.kocci.disastertracker.databinding.ActivityMainBinding
import com.kocci.disastertracker.util.helper.MyLogger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyLogger.e("Oncreate Activity")

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val controller = navHostFragment.navController
        binding.botNavView.setupWithNavController(controller)

    }
}