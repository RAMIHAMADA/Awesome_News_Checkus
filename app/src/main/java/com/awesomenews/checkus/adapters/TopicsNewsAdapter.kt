package com.awesomenews.checkus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.awesomenews.checkus.R
import com.awesomenews.checkus.adapters.TopicsNewsAdapter.*
import com.awesomenews.checkus.ui.news.topics.NewsTopicsFragment

class TopicsNewsAdapter(private val infoModel: NewsTopicsFragment, allCategory: List<Any>) :
    RecyclerView.Adapter<TopicsNewsViewHolder>() {

    class TopicsNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         lateinit var categoryTitle: TextView

        init {
            categoryTitle = itemView.findViewById(R.id.title_item_news_topics_tv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsNewsViewHolder {
        return TopicsNewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_title_news_topics_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopicsNewsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return infoModel.size
    }

}