package com.example.cryptoapp.domain.model

import com.example.cryptoapp.data.remote.dto.coin.CoinDto
import com.squareup.moshi.Json

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
)


