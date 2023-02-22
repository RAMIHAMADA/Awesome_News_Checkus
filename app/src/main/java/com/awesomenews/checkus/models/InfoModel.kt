package com.awesomenews.checkus.models

import java.io.Serializable

data class InfoModel(
    val title: String? = "",
    val imageLink: String? = "",
    val date_added: Long = 0L,
    val text: String? = ""
): Serializable

