package com.example.cryptoapp.data.remote.dto.coin


import com.example.cryptoapp.domain.model.Coin
import com.squareup.moshi.Json

data class CoinDto(
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

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        isActive = isActive
    )
}