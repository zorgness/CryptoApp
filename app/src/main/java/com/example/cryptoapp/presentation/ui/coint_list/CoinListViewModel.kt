package com.example.cryptoapp.presentation.ui.coint_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.Resource
import com.example.cryptoapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {

    init {
        getCoins()
    }
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    private fun getCoins() {
        getCoinsUseCase().onEach{ result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coinsList = result.data ?:
                    emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?:
                    "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

} 