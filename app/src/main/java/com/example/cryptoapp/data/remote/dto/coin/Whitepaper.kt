package com.example.cryptoapp.data.remote.dto.coin


import com.squareup.moshi.Json

data class Whitepaper(
    @Json(name = "link")
    val link: String,
    @Json(name = "thumbnail")
    val thumbnail: String
)