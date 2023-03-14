package com.awesomenews.checkus.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoModel(
    val title: String? = "",
    val imageLink: String = "",
    val date_added: Long = 0L,
    val text: String? = "",
): Parcelable

