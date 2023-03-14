package com.awesomenews.checkus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awesomenews.checkus.databinding.ItemCategoryNewsBinding
import com.awesomenews.checkus.models.CategoryNewsModel

class CategoryNewsAdapter() : RecyclerView.Adapter<CategoryNewsAdapter.CategoryNewsViewHolder>() {
    var category: List<CategoryNewsModel> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }
    class CategoryNewsViewHolder(val binding: ItemCategoryNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryNewsBinding.inflate(inflater, parent, false)

        return CategoryNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNewsViewHolder, position: Int) {
        val category = category[position]
        with(holder.binding){
            titleTv.text = category.categoryTitle
            val adapter = NewsTopicsAdapter()
            adapter.news = category.list
            recyclerView.adapter = adapter
        }
    }

    override fun getItemCount() = category.size
}