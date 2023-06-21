package com.example.cryptoapp.network.dto.coin


import com.squareup.moshi.Json

data class Tag(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "coin_counter")
    val coinCounter: Int,
    @Json(name = "ico_counter")
    val icoCounter: Int
)