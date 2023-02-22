package com.awesomenews.checkus.adapters

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


class CardNewsAdapter(private val listener: Listener) :
    ListAdapter<InfoModel, CardNewsAdapter.CardNewsViewHolder>(ItemCallBack),
    View.OnClickListener {

    class CardNewsViewHolder(val binding: ItemCardNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface Listener {
        fun onClickInfoModel(infoModel: InfoModel)
    }

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

            dateNewsTv.text = news.date_added.toString()
            titleNewsTv.text = news.title
            if (news.imageLink?.isEmpty()!!) {
                pictureIv.setImageResource(R.drawable.ic_news_download)
            } else {
                pictureIv.load(news.imageLink) {
                    placeholder(R.drawable.ic_news_download)
                }
            }
        }
    }

    override fun onClick(view: View) {
        val newsCard = view.tag as InfoModel
        listener.onClickInfoModel(newsCard)
    }
}