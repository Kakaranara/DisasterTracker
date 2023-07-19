package com.kocci.disastertracker.presenter.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kocci.disastertracker.databinding.FragmentReportBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportFragment : Fragment(), View.OnClickListener {
    private var _binidng : FragmentReportBinding? = null
    private val binding get() = _binidng!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binidng = FragmentReportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.toolbarHome.setupWithNavController(findNavController())
//
//        binding.apply {
//            btnToReportPage.setOnClickListener(this@HomeFragment)
//        }


    }

    override fun onClick(v: View?) {
        when(v){

        }
    }
}