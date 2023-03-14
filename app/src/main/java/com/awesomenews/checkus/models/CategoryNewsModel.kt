package com.awesomenews.checkus.models


data class CategoryNewsModel(
    val categoryTitle: String = "",
    val list: List<InfoModel> = emptyList()
)