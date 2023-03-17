package com.awesomenews.checkus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awesomenews.checkus.R
import com.awesomenews.checkus.databinding.ItemCardNewsBinding
import com.awesomenews.checkus.models.CategoryNewsModel

class ListOfAllNewsAdapter() :
    ListAdapter<CategoryNewsModel, ListOfAllNewsAdapter.ListOfAllNewsViewHolder>(ItemCallBack) {

    class ListOfAllNewsViewHolder(binding: ItemCardNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    object ItemCallBack : DiffUtil.ItemCallback<CategoryNewsModel>() {
        override fun areItemsTheSame(
            oldItem: CategoryNewsModel,
            newItem: CategoryNewsModel
        ): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }

        override fun areContentsTheSame(
            oldItem: CategoryNewsModel,
            newItem: CategoryNewsModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardNewsAdapter.CardNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardNewsBinding.inflate(inflater, parent, false)

        return CardNewsAdapter.CardNewsViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ListOfAllNewsViewHolder, position: Int) {
        val news = getItem(position)

        with(holder.binding)


    }
}