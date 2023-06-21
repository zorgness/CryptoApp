package com.example.cryptoapp.domain.model

import com.example.cryptoapp.data.remote.dto.coin.Tag
import com.example.cryptoapp.data.remote.dto.coin.TeamMember

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<Tag>,
    val team: List<TeamMember>
)



