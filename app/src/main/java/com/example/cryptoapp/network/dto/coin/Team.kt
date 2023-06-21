package com.example.cryptoapp.network.dto.coin


import com.squareup.moshi.Json

data class Team(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "position")
    val position: String
)