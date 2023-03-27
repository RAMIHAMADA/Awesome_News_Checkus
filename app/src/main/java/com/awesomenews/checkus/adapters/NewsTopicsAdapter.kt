package com.awesomenews.checkus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.ItemNewsBinding
import com.awesomenews.checkus.models.InfoModel

class NewsTopicsAdapter() : RecyclerView.Adapter<NewsTopicsAdapter.NewsTopicsViewHolder>() {
    var news: List<InfoModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }


    class NewsTopicsViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsTopicsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)

        return NewsTopicsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsTopicsViewHolder, position: Int) {
        val news = news[position]
        with(holder.binding) {
            root.tag = news
            titleNewsTv.text = news.title
            dateNewsTv.text = news.date_added.toString()
            if (news.image.isEmpty()) {
                pictureIv.setImageResource(R.drawable.ic_news_download)
            } else {
                pictureIv.load(news.image) {
                    placeholder(R.drawable.ic_news_download)
                }
            }
        }
    }

    override fun getItemCount() = news.size



}