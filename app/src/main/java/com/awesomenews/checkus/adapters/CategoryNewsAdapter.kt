package com.awesomenews.checkus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awesomenews.checkus.databinding.ItemCategoryNewsBinding
import com.awesomenews.checkus.models.CategoryNewsModel

class CategoryNewsAdapter(private val listener: (CategoryNewsModel) -> Unit) :
    RecyclerView.Adapter<CategoryNewsAdapter.CategoryNewsViewHolder>(), View.OnClickListener {
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
        binding.backgroundForArrowV.setOnClickListener(this)


        return CategoryNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNewsViewHolder, position: Int) {
        val category = category[position]
        with(holder.binding) {
            backgroundForArrowV.tag = category
            titleTv.text = category.categoryTitle
            val adapter = NewsTopicsAdapter()
            adapter.news = category.list
            recyclerView.adapter = adapter
        }
    }

    override fun getItemCount() = category.size

    override fun onClick(view: View) {
        val categoryNews = view.tag as CategoryNewsModel
        listener(categoryNews)
    }

}