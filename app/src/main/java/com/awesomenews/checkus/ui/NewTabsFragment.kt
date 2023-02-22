package com.awesomenews.checkus.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.FragmentNewTabsBinding

class NewTabsFragment: Fragment() {
    private var _binding: FragmentNewTabsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewTabsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigation()
    }

    private fun initNavigation(){
        val navHost=
            childFragmentManager.findFragmentById(R.id.new_tabs_fragment_container) as NavHostFragment
        val navController = navHost.navController

        NavigationUI.setupWithNavController(binding.bottomNavMenu, navController)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}



