package com.awesomenews.checkus.ui.details.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.FragmentDetailsNewsBinding

class DetailsNewsFragment : Fragment() {
    private var _binding : FragmentDetailsNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentDetailsNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}

