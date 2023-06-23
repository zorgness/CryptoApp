package com.example.cryptoapp.presentation.ui.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.cryptoapp.data.remote.dto.coin.TeamMember

@Composable
fun TeamListItem(
    member: TeamMember,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = member.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = member.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }

}