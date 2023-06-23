package com.example.cryptoapp.presentation.ui.coin_detail

import CoinTag
import com.example.cryptoapp.presentation.ui.coin_detail.components.TeamListItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel,
    coinId: String
) {

    val state = viewModel.state.value

    LaunchedEffect(true ) {
        viewModel.getCoin(coinId)
    }

    CoinDetailContent(state)
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailContent(
    state: CoinDetailState
) {
        Box(modifier = Modifier.fillMaxSize()) {
            state.coin?.let { coin ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                                style = MaterialTheme.typography.h2,
                                modifier = Modifier.weight(8f)
                            )

                            Text(
                                text = if (coin.isActive) "active" else "inactive",
                                color = if(coin.isActive) Color.Green else Color.Red,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .align(CenterVertically)
                                    .weight(2f)

                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = coin.description,
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Tags",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            maxItemsInEachRow = 3

                        ) {
                            coin.tags.forEach { tag ->

                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                ) {
                                    CoinTag(tag = tag.name)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Team members",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    items(coin.team) { teamMember ->
                        TeamListItem(
                            member = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                        Divider()
                    }
                }
            }

            if(state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)

                )
            }

            if(state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
}

