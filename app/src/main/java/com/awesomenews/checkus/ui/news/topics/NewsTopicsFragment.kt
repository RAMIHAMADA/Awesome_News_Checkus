package com.awesomenews.checkus.ui.news.topics

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.awesomenews.checkus.adapters.TopicsNewsAdapter
import com.awesomenews.checkus.databinding.FragmentNewsTopicsBinding
import com.awesomenews.checkus.models.InfoModel
import com.awesomenews.checkus.models.TitleModel
import kotlinx.android.synthetic.main.item_new_topics_scroll_card.*
import com.awesomenews.checkus.ui.news.topics.NewsTopicsFragment as NewsTopicsFragment1

class NewsTopicsFragment : Fragment() {
    private var newsTopicsCategoryRecycler: RecyclerView? = null
    private var topicsNewsAdapter: TopicsNewsAdapter? = null


    private var _binding: FragmentNewsTopicsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsTopicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val titleModel: MutableList<TitleModel> = ArrayList()
        titleModel.add(TitleModel("Лучшая новость"))
        titleModel.add(TitleModel("Самая лучшая новость"))
        titleModel.add(TitleModel("Такая себе новость "))
        titleModel.add(TitleModel("Можно было лучше"))
        titleModel.add(TitleModel("Вот это я понимаю"))

        setTopicsNewsCategoryRecycler(titleModel)

    }

    private fun setTopicsNewsCategoryRecycler(titleModel: List<TitleModel>){
        newsTopicsCategoryRecycler = binding.recyclerViewNewsTopics
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        newsTopicsCategoryRecycler!!.layoutManager = layoutManager
        topicsNewsAdapter = TopicsNewsAdapter(this, titleModel)
        newsTopicsCategoryRecycler!!.adapter = topicsNewsAdapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}