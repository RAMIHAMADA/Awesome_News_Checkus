package com.awesomenews.checkus.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.ItemCardNewsBinding
import com.awesomenews.checkus.models.InfoModel
import com.google.type.Date
import okhttp3.internal.format
import java.text.DateFormat
import java.text.SimpleDateFormat

class CardNewsAdapter(private val listener:(InfoModel)-> Unit) :
    ListAdapter<InfoModel, CardNewsAdapter.CardNewsViewHolder>(ItemCallBack),
    View.OnClickListener {

    class CardNewsViewHolder(val binding: ItemCardNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    object ItemCallBack : DiffUtil.ItemCallback<InfoModel>() {

        override fun areItemsTheSame(oldItem: InfoModel, newItem: InfoModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: InfoModel, newItem: InfoModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardNewsBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)

        return CardNewsViewHolder(binding = binding)
    }


    override fun onBindViewHolder(holder: CardNewsViewHolder, position: Int) {
        val news = getItem(position)

        with(holder.binding) {
            root.tag = news

            titleNewsTv.text = news.title
            dateNewsTv.text = convertLongToTime(news.date_added)
            if (news.image?.isEmpty()!!) {
                pictureIv.setImageResource(R.drawable.ic_news_download)
            } else {
                pictureIv.load(news.image) {
                    placeholder(R.drawable.ic_news_download)
                }
            }
        }
    }

    override fun onClick(view: View) {
        val newsCard = view.tag as InfoModel
        listener(newsCard)
    }

    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time:Long): String{
        val dateNews = java.sql.Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return format.format(dateNews)
    }
}