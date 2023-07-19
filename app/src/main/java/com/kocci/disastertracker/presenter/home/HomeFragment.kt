package com.kocci.disastertracker.presenter.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kocci.disastertracker.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), View.OnClickListener {
    private var _binidng: FragmentHomeBinding? = null
    private val binding get() = _binidng!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binidng = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarHome.setupWithNavController(findNavController())

        binding.apply {
            btnToReportPage.setOnClickListener(this@HomeFragment)
        }


    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnToReportPage -> {
                val dir = HomeFragmentDirections.actionHomeFragmentToReportFragment()
                findNavController().navigate(dir)
            }
        }
    }
}