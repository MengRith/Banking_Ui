package kh.com.rith.dev.bankui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.data.Favorite
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme
import kh.com.rith.dev.bankui.ui.theme.LightBlue
import kh.com.rith.dev.bankui.ui.theme.Smoke

val FavoriteList = listOf(
    Favorite(
        "MK",
        "Mom",
        Color(0xFFE8ECFF),
        Color(0xFF2B4BDB)
    ),
    Favorite(
        "SP",
        "Sophea",
        Color(0xFFFFF0D2),
        Color(0xFF8A5A00)
    ),
    Favorite(
        "LD",
        "Land Lord",
        Color(0xFFE3F4EC),
        Color(0xFF0F7B4A)
    ),
    Favorite(
        "EC",
        "Electric",
        Color(0xFFEEE7FB),
        Color(0xFF6B3FC9)
    ),
)

@Composable
fun ScreenFavorite() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Favorites",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(start = 8.dp))
            Text(
                text = " ចំណូលចិត្ត",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See all",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Blue

            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(vertical = 20.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FavoriteList.forEach { favorite ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(favorite.backgroundColor),
                            contentAlignment = Alignment.Center
                        ) {


                            Text(
                                text = favorite.shortName,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = favorite.textColor
                            )
                        }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = favorite.fullName,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    }
                }

            }
    }

}


@Preview(showBackground = true)
@Composable
fun ScreenFavoritePreview() {
    BankUiTheme() {
        ScreenFavorite()
    }
}