package com.example.cryptoapp.network

import com.example.cryptoapp.network.dto.coin.CoinDto
import com.example.cryptoapp.network.dto.coin.GetCoinsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceCoin {

    @GET(ApiRoutes.COIN_PAPRIKA_URL)
    suspend fun fetchAllCoins(): Response<GetCoinsDto>

    @GET(ApiRoutes.COIN_PAPRIKA_URL)
    suspend fun getCoinById(@Path("id") idStr: String): Response<CoinDto>
}