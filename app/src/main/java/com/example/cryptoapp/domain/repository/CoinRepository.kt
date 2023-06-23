package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coin.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}