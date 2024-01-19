package com.example.cryptoapp.data.remote.repository

import com.example.cryptoapp.data.remote.ApiServiceCoin
import com.example.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coin.CoinDto
import com.example.cryptoapp.data.remote.dto.coin.Tag
import com.example.cryptoapp.data.remote.dto.coin.TeamMember
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class CoinRepositoryImplTest {

    private lateinit var apiServiceCoin: ApiServiceCoin
    private lateinit var coinRepository: CoinRepository

    @Before
    fun setUp() {
        apiServiceCoin = mock(ApiServiceCoin::class.java)
        coinRepository = CoinRepositoryImpl(apiServiceCoin)
    }

    @Test
    fun `getCoins should return a list of coins`() = runBlocking {
        // Given
        val expectedCoins = listOf(
           CoinDto(
                id = "btc-bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                rank = 1,
                isNew = false,
                isActive = true,
                type = "coin"
            )
        )
        `when`(apiServiceCoin.getCoins()).thenReturn(expectedCoins)

        // When
        val actualCoins = coinRepository.getCoins()

        // Then
        assertEquals(expectedCoins, actualCoins)
    }

    @Test
    fun `getCoinById should return a coin detail`() = runBlocking {
        // Given
        val coinId = "btc-bitcoin"
        val expectedCoinDetail = CoinDetailDto(
            id = "btc-bitcoin",
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1,
            isNew = false,
            isActive = true,
            type = "coin",
            logo = "https://static.coinpaprika.com/coin/btc-bitcoin/logo.png",
            tags = tags,
            team = teamMembers,
            description = "Bitcoin is a cryptocurrency and worldwide payment system. It is the first decentralized digital currency, as the system works without a central bank or single administrator."

        )
        `when`(apiServiceCoin.getCoinById(coinId)).thenReturn(expectedCoinDetail)

        // When
        val actualCoinDetail = coinRepository.getCoinById(coinId)

        // Then
        assertEquals(expectedCoinDetail, actualCoinDetail)
    }
}

val tags: List<Tag> = listOf(
    Tag(id = "segwit", name = "Segwit", coinCounter = 10, icoCounter = 0),
    Tag(id = "cryptocurrency", name = "Cryptocurrency", coinCounter = 1065, icoCounter = 40),
    Tag(id = "proof-of-work", name = "Proof Of Work", coinCounter = 513, icoCounter = 14),
    Tag(id = "payments", name = "Payments", coinCounter = 169, icoCounter = 39),
    Tag(id = "sha256", name = "Sha256", coinCounter = 47, icoCounter = 1),
    Tag(id = "mining", name = "Mining", coinCounter = 272, icoCounter = 18),
    Tag(id = "lightning-network", name = "Lightning Network", coinCounter = 6, icoCounter = 0)
)

val teamMembers: List<TeamMember> = listOf(
    TeamMember("satoshi-nakamoto", "Satoshi Nakamoto", "Founder"),
    TeamMember("wladimir-j-van-der-laan", "Wladimir J. van der Laan", "Blockchain Developer"),
    TeamMember("jonas-schnelli", "Jonas Schnelli", "Blockchain Developer"),
    TeamMember("marco-falke", "Marco Falke", "Blockchain Developer"),
    TeamMember("rahul", "Rahul", "Node js Developer"),
    TeamMember("ashutosh", "Ashutosh", "Whale Miner"),
    TeamMember("turd-fergason", "Turd Fergason", "Blockchain Devolper")
)

