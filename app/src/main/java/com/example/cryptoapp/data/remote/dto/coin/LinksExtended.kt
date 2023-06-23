package com.example.cryptoapp.data.remote.dto.coin


import com.squareup.moshi.Json

data class LinksExtended(
    @Json(name = "url")
    val url: String,
    @Json(name = "type")
    val type: String,
   /* @Json(name = "stats")
    val stats: Stats*/
)