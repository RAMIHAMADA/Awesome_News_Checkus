package com.awesomenews.checkus.ui.details.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.FragmentDetailsNewsBinding

class DetailsNewsFragment : Fragment() {
    private var _binding: FragmentDetailsNewsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsNewsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transferInfo()
        initClickArrowBack()
    }



    private fun initClickArrowBack(){
        binding.backgroundForArrowV.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun transferInfo() {
        binding.titleDetalisFragmentTv.text = args.newsDetalis.title
        binding.dateDetalisFragmentTv.text = args.newsDetalis.date_added.toString()
        binding.textDetalisNewsFragment.text = args.newsDetalis.text
        if (args.newsDetalis.image?.isEmpty()!!) {
            binding.detalisNewsFragmentIv.setImageResource(R.drawable.ic_news_download)
        } else {
            binding.detalisNewsFragmentIv.load(args.newsDetalis.image) {
                placeholder(R.drawable.ic_news_download)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}







