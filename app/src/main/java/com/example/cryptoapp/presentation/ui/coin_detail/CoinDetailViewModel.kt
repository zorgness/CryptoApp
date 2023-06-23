package com.example.cryptoapp.presentation.ui.coin_detail

import COIN_ID
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.Resource
import com.example.cryptoapp.domain.model.CoinDetail
import com.example.cryptoapp.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptoapp.presentation.ui.coint_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel  @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {

       /* savedStateHandle.get<String>(COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }*/
    }

     fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success ->
                    _state.value = CoinDetailState(coin = result.data)

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?:
                    "An unexpected error occurred")
                }
                is Resource.Loading ->
                    _state.value = CoinDetailState(isLoading = true)

            }
        }.launchIn(viewModelScope)
    }
}