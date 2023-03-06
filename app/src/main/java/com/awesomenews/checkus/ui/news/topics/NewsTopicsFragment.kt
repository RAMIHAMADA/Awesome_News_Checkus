package com.awesomenews.checkus.ui.news.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.awesomenews.checkus.adapters.TopicsNewsAdapter
import com.awesomenews.checkus.databinding.FragmentNewsTopicsBinding
import com.awesomenews.checkus.models.TitleModel


class NewsTopicsFragment : Fragment() {

    private lateinit var adapter1: TopicsNewsAdapter
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
    //todo  разобраться с инициализацией  в инитадаптаре, так как то что написано прямо сейчас не правильно
    private fun initAdapter() {
        adapter1 = TopicsNewsAdapter(object : TopicsNewsAdapter.Listener{
            override fun onClickTitleModel(titleModel: TitleModel) {

            }
        })
        binding.recyclerViewNewsTopics.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewNewsTopics.adapter = adapter1

        val list = mutableListOf(
            TitleModel("Новости будут тут"),
            TitleModel("Точно будут новости"),
            TitleModel("Совсем скоро будут новости"),
            TitleModel("Новости со всего мира"),
            TitleModel("Локальные новости"),
            TitleModel("Новости про тракторы")
        )
        adapter1.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
