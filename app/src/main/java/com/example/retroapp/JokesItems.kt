package com.example.retroapp


import com.google.gson.annotations.SerializedName

import androidx.annotation.Keep

@Keep

data class JokesItems(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: Value
)