package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coin.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceCoin {

    @GET(ApiRoutes.COIN_PAPRIKA_URL)
    suspend fun getCoins(): List<CoinDto>

    @GET(ApiRoutes.COIN_PAPRIKA_URL + "/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}