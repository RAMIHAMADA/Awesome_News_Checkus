package com.awesomenews.checkus.ui.list.of.all.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.awesomenews.checkus.adapters.CardNewsAdapter
import com.awesomenews.checkus.databinding.FragmentListOfAllNewsBinding
import com.awesomenews.checkus.models.InfoModel
import com.awesomenews.checkus.utils.GetNews


class ListOfAllNewsFragment : Fragment() {
    private lateinit var adapter: CardNewsAdapter
    private var _binding: FragmentListOfAllNewsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ListOfAllNewsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListOfAllNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClickArrowBack()
        transferInfo()
    }

    private fun initAdapter() {
        adapter = CardNewsAdapter {
            navigateTo(it)
        }
        binding.recyclerViewMainScreen.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMainScreen.adapter = adapter

        adapter.submitList(
            GetNews.getListNews()
        )
    }

    private fun initClickArrowBack() {
        binding.arrowBackgroundV.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun transferInfo() {
        binding.topicTitleTv.text = args.categoryName.categoryTitle
    }

    private fun navigateTo(news_detalis: InfoModel){
        findNavController().navigate(
            ListOfAllNewsFragmentDirections.actionListOfAllNewsFragmentToDetailsNewsFragment2(
             newsDetalis = news_detalis
            )
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}




