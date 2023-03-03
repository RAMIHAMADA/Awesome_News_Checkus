package com.awesomenews.checkus.ui.news.topics

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

class NewsTopicsFragment : Fragment() {

    private var topicsRecyclerView: RecyclerView? = null
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val allCategory: MutableList<InfoModel> = arrayListOf()
//        allCategory.add(1, InfoModel("Новая новость"))
//        allCategory.add(1, InfoModel("Старая новость"))
//        allCategory.add(1, InfoModel("Крутая новость"))
//        allCategory.add(1, InfoModel("Не крутая новость"))
//        allCategory.add(1, InfoModel("Такая себе новость"))
//        allCategory.add(1, InfoModel("Фейковая новость"))
//        allCategory.add(1, InfoModel("Трушная новость"))
//
//        setMainTopicsNewCategory(allCategory)
    }

//    private fun setMainTopicsNewCategory(infoModel: InfoModel) {
//        topicsRecyclerView = binding.recyclerViewNewsTopics
//        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
//        topicsRecyclerView!!.layoutManager = layoutManager
//        topicsNewsAdapter = TopicsNewsAdapter(this,allCategory)
//        topicsRecyclerView!!.adapter = topicsNewsAdapter
//
//
//
//    }

}