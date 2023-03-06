package com.awesomenews.checkus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.awesomenews.checkus.databinding.ItemTitleNewsTopicsCardBinding
import com.awesomenews.checkus.models.TitleModel

class TopicsNewsAdapter(private val listener: Listener) :
    ListAdapter<TitleModel, TopicsNewsAdapter.TopicsNewsViewHolder>(ItemCallback),
    View.OnClickListener {


    class TopicsNewsViewHolder(val binding: ItemTitleNewsTopicsCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    interface Listener {
        fun onClickTitleModel(titleModel: TitleModel)
    }

    object ItemCallback : DiffUtil.ItemCallback<TitleModel>() {
        override fun areItemsTheSame(oldItem: TitleModel, newItem: TitleModel): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }

        override fun areContentsTheSame(oldItem: TitleModel, newItem: TitleModel): Boolean {
            return oldItem == newItem

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTitleNewsTopicsCardBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)
        return  TopicsNewsViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: TopicsNewsViewHolder, position: Int) {
        val title = getItem(position)

        with(holder.binding){
            root.tag = title
            titleItemNewsTopicsTv.text = title.categoryTitle
        }
    }

    override fun onClick(view: View) {
        val itemTitle = view.tag as TitleModel
        listener.onClickTitleModel(itemTitle)
    }


}