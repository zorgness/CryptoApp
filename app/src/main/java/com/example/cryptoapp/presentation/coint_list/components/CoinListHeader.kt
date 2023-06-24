import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CoinListHeader(
    onLogoutIconClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Icon(
            Icons.Outlined.ExitToApp,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.CenterEnd)
                .padding(8.dp)
                .clickable { onLogoutIconClicked() }
        )
    }
}