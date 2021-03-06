package com.example.retroapp


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep

data class Value(
    @SerializedName("categories")
    val categories: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String
)