package com.example.cryptoapp.presentation.coint_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.Resource
import com.example.cryptoapp.data.remote.ApiServiceCoin
import com.example.cryptoapp.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptoapp.service.SharedPreferencesService
import com.example.cryptoapp.utils.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val apiServiceCoin: ApiServiceCoin,
    private val getCoinsUseCase: GetCoinsUseCase,
    private val sharedPref: SharedPreferencesService
): ViewModel() {


    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    private val _goToLoginSharedFlow = MutableSharedFlow<Screen>()
    val goToLoginSharedFlow = _goToLoginSharedFlow.asSharedFlow()


    init {
        getCoins()
    }

    fun logout() {
        sharedPref.clearSharedPref()
        viewModelScope.launch {
            _goToLoginSharedFlow.emit(Screen.Login)
        }
    }

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