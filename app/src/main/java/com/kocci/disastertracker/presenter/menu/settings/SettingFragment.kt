package com.kocci.disastertracker.presenter.menu.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.kocci.disastertracker.R
import com.kocci.disastertracker.databinding.FragmentSettingBinding
import com.kocci.disastertracker.util.extension.showToast
import com.kocci.disastertracker.util.helper.MyLogger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment() {
    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarSetting.setupWithNavController(findNavController())

        val isDarkModeEnabled = viewModel.isDarkModeEnabled
        binding.switchDarkMode.isChecked = isDarkModeEnabled

        MyLogger.e("OnView Before: $isDarkModeEnabled")

        binding.switchDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                viewModel.enableDarkTheme()
            } else {
                viewModel.disableDarkTheme()
            }
        }

        MyLogger.e("OnView After: $isDarkModeEnabled")
        (binding.acTvTimePeriod as? MaterialAutoCompleteTextView)?.setSimpleItems(viewModel.showAvailableTime())
        binding.acTvTimePeriod.setText(viewModel.userTimePreference, false)

        binding.acTvTimePeriod.setOnItemClickListener { _, _, _, _ ->
            val text = binding.acTvTimePeriod.text.toString()
            viewModel.setTimePeriod(text)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}