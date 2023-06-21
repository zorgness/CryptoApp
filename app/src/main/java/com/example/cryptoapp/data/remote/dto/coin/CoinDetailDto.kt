package com.example.cryptoapp.data.remote.dto.coin


import com.example.cryptoapp.domain.model.CoinDetail
import com.squareup.moshi.Json

data class CoinDetailDto(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "is_new")
    val isNew: Boolean,
    @Json(name = "is_active")
    val isActive: Boolean,
    @Json(name = "type")
    val type: String,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "tags")
    val tags: List<Tag>,
    @Json(name = "team")
    val team: List<TeamMember>,
    @Json(name = "description")
    val description: String,
    @Json(name = "message")
    val message: String,
    @Json(name = "open_source")
    val openSource: Boolean,
    @Json(name = "started_at")
    val startedAt: String,
    @Json(name = "development_status")
    val developmentStatus: String,
    @Json(name = "hardware_wallet")
    val hardwareWallet: Boolean,
    @Json(name = "proof_type")
    val proofType: String,
    @Json(name = "org_structure")
    val orgStructure: String,
    @Json(name = "hash_algorithm")
    val hashAlgorithm: String,
    @Json(name = "links")
    val links: Links,
    @Json(name = "links_extended")
    val linksExtended: List<LinksExtended>,
    @Json(name = "whitepaper")
    val whitepaper: Whitepaper,
    @Json(name = "first_data_at")
    val firstDataAt: String,
    @Json(name = "last_data_at")
    val lastDataAt: String
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id,
        name,
        description,
        symbol,
        rank,
        isActive,
        tags,
        team
    )
}