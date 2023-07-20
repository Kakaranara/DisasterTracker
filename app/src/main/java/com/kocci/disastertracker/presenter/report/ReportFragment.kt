package com.kocci.disastertracker.presenter.report

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kocci.disastertracker.databinding.FragmentReportBinding
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentReportBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ReportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner) {
            when (it) {
                is Async.Error -> {
                    showToast("Error : ${it.message}")
                }

                Async.Loading -> {
                    showToast("Loading..")
                }

                is Async.Success -> {
                    Log.d("TEST", "onViewCreated: ${it.data}")

                    val mAdapter = ReportListAdapter(it.data)
                    val layout = LinearLayoutManager(requireActivity())
                    binding.rvReportList.apply {
                        adapter = mAdapter
                        layoutManager = layout
                    }

                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {

        }
    }
}