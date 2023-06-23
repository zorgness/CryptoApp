package com.example.cryptoapp.presentation.ui.coint_list

import CoinListHeader
import CoinListItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.utils.Screen

@Composable
fun CoinListScreen(
    navController: NavHostController,
    viewModel: CoinListViewModel
) {

    LaunchedEffect(true) {
        viewModel.goToLoginSharedFlow.collect {
            navController.navigate(it.route) {
                popUpTo(Screen.Main.route) {
                    inclusive = true
                }
            }
        }
    }

    val state = viewModel.state.value
    CoinListContent(
        coinsList = state.coinsList,
        error = state.error,
        isLoading = state.isLoading,
        handleItemClicked = {coin ->
            navController.navigate(
                Screen.CoinDetail.route + "/${coin.id}"
            )
        },
        handleLogout = {
            viewModel.logout()
        }


    )
}

@Composable
fun CoinListContent(
    coinsList: List<Coin>,
    error: String,
    isLoading: Boolean,
    handleItemClicked: (Coin) -> Unit,
    handleLogout: () -> Unit
) {
    Column() {

        CoinListHeader { handleLogout() }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(coinsList) { coin ->
                    CoinListItem(
                        coin = coin,
                        onItemClicked =  { handleItemClicked(coin) }
                    )
                }

            }
            if(error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)

                )
            }

            if(isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }

    }

}
