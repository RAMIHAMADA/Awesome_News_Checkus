package com.awesomenews.checkus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.awesomenews.checkus.R
import com.awesomenews.checkus.models.TitleModel


class TopicsNewsAdapter(private val context: Context, private val titleModel: List<TitleModel>) :
    RecyclerView.Adapter<TopicsNewsAdapter.TopicsNewsHolder>() {

    class TopicsNewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var categoryTitle: TextView? = null

        init {
            categoryTitle = itemView.findViewById(R.id.title_item_news_topics_tv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsNewsHolder {
        return TopicsNewsHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_title_news_topics_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopicsNewsHolder, position: Int) {
        holder.categoryTitle!!.text = titleModel[position].categoryTitle
    }

    override fun getItemCount(): Int {
        return titleModel.size
    }


}


