package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coin.GetCoinsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceCoin {

    @GET(ApiRoutes.COIN_PAPRIKA_URL)
    suspend fun getCoins(): Response<GetCoinsDto>

    @GET(ApiRoutes.COIN_PAPRIKA_URL + "/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): Response<CoinDetailDto>
}