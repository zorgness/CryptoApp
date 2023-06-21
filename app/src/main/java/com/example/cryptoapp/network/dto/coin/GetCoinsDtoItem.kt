package com.example.cryptoapp.network.dto.coin


import com.squareup.moshi.Json

data class GetCoinsDtoItem(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "is_new")
    val isNew: Boolean,
    @Json(name = "is_active")
    val isActive: Boolean,
    @Json(name = "type")
    val type: String
)