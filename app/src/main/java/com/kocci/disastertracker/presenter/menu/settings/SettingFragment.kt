package com.kocci.disastertracker.presenter.menu.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kocci.disastertracker.R
import com.kocci.disastertracker.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment() {
    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarSetting.setupWithNavController(findNavController())

        var isDarkModeEnabled = viewModel.isDarkModeEnabled
        binding.switchDarkMode.isChecked = isDarkModeEnabled

        binding.switchDarkMode.setOnClickListener {
            if (isDarkModeEnabled) {
                viewModel.disableDarkTheme()
                isDarkModeEnabled = false
            } else {
                viewModel.enableDarkTheme()
                isDarkModeEnabled = true
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}