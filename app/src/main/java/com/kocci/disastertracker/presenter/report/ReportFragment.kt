package com.kocci.disastertracker.presenter.report

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kocci.disastertracker.R
import com.kocci.disastertracker.databinding.FragmentReportBinding
import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.util.extension.gone
import com.kocci.disastertracker.util.extension.showToast
import com.kocci.disastertracker.util.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportFragment : Fragment(), View.OnClickListener, OnMapReadyCallback {
    private var _binding: FragmentReportBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ReportViewModel by viewModels()

    var reportList: List<Reports>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner) {
            when (it) {
                is Async.Error -> {
                    binding.loadingReport.gone()
                    showToast("Error : ${it.message}")
                }

                Async.Loading -> {
                    binding.loadingReport.visible()
                }

                is Async.Success -> {
                    Log.d("TEST", "onViewCreated: ${it.data}")

                    binding.loadingReport.gone()
                    val mAdapter = ReportListAdapter(it.data)
                    val layout = LinearLayoutManager(requireActivity())
                    binding.rvReportList.apply {
                        adapter = mAdapter
                        layoutManager = layout
                    }
                    updateMapWithData(it.data)
                }
            }
        }
    }

    override fun onMapReady(maps: GoogleMap) {
        reportList?.let {
            val coor = it[0].coordinates
            val latLng = LatLng(coor.lat, coor.lng)
            maps.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 8f))
            it.forEach { data ->
                maps.addMarker(
                    MarkerOptions().position(LatLng(data.coordinates.lat, data.coordinates.lng))
                        .title(data.title).snippet("Disaster : ${data.disasterType}")
                )
            }
        } ?: showToast("data is null")
    }

    private fun updateMapWithData(data: List<Reports>?) {
        if (data != null && data.isNotEmpty()) {
            reportList = data
            // Since data is not null and not empty, update the map with the data
            val mapFragment =
                childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment?
            mapFragment?.getMapAsync(this)
        } else {
            showToast("Data is null or empty")
        }
    }

    override fun onClick(v: View?) {
        when (v) {

        }
    }
}