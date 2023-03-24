package com.awesomenews.checkus.ui.main.screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.awesomenews.checkus.adapters.CardNewsAdapter
import com.awesomenews.checkus.data.GettingData
import com.awesomenews.checkus.databinding.FragmentMainScreenBinding
import com.awesomenews.checkus.models.InfoModel
import com.awesomenews.checkus.utils.GetNews

class MainScreenFragment : Fragment() {
    private lateinit var adapter: CardNewsAdapter
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
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

    // осуществлена навигация с фрагмента MainScreenFragment на DetailsNewsFragment
    private fun navigateTo(news_detalis: InfoModel) {
        findNavController().navigate(
            MainScreenFragmentDirections.actionMainScreenFragmentToDetailsNewsFragment(
                newsDetalis = news_detalis
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}