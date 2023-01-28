package com.awesomenews.checkus.ui.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.FragmentSplashBinding
import kotlinx.coroutines.*

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateNext()
    }


    private fun navigateNext() {
        CoroutineScope(Dispatchers.Main).launch {
//            delay(1000)
            findNavController().navigate(R.id.action_splashFragment_to_blankFragment)
        }

    }

}