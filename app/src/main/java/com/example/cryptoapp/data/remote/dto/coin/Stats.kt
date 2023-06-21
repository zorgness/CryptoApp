package com.example.cryptoapp.data.remote.dto.coin


import com.squareup.moshi.Json

data class Stats(
    @Json(name = "subscribers")
    val subscribers: Int,
    @Json(name = "contributors")
    val contributors: Int,
    @Json(name = "stars")
    val stars: Int,
    @Json(name = "followers")
    val followers: Int
)