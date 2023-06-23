package com.example.cryptoapp.data.remote.repository

import com.example.cryptoapp.data.remote.ApiServiceCoin
import com.example.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coin.CoinDto
import com.example.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiServiceCoin: ApiServiceCoin
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return apiServiceCoin.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return apiServiceCoin.getCoinById(coinId)
    }
}