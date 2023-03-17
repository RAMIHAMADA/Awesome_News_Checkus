package com.awesomenews.checkus.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryNewsModel(
    val categoryTitle: String = "",
    val list: List<InfoModel> = emptyList()
): Parcelable