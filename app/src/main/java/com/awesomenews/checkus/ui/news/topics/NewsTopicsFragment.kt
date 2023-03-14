package com.awesomenews.checkus.ui.news.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.awesomenews.checkus.adapters.CategoryNewsAdapter
import com.awesomenews.checkus.databinding.FragmentNewsTopicsBinding
import com.awesomenews.checkus.utils.GetNews


class NewsTopicsFragment : Fragment() {
    private lateinit var adapter: CategoryNewsAdapter
    private var _binding: FragmentNewsTopicsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsTopicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }
    private fun initAdapter(){
        adapter = CategoryNewsAdapter()
        adapter.category = GetNews.getCategoryNewsList()
        binding.recyclerViewNewsTopics.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewNewsTopics.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
