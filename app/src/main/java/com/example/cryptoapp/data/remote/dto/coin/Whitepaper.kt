package com.example.cryptoapp.data.remote.dto.coin


import com.squareup.moshi.Json

data class Whitepaper(
    @Json(name = "link")
    val link: String? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null,
)