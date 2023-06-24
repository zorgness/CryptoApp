package com.example.cryptoapp.presentation.coint_list

import com.example.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinsList: List<Coin> = emptyList(),
    val error: String = ""
)
