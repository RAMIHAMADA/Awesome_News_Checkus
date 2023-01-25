package com.awesomenews.checkus.ui.news.topics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.FragmentNewsTopicsBinding

class NewsTopicsFragment : Fragment() {
    private var _binding: FragmentNewsTopicsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsTopicsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}