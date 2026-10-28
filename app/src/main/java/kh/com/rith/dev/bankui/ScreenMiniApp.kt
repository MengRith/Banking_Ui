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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.data.MiniApp
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme

val MiniAppList = listOf(
    MiniApp(
        icon = R.drawable.ic_bike,
        title = "Ride",
        backgroundColor = Color(0xFFE8ECFF),
        Color(0xFF2B4BDB)
    ),
 MiniApp(
        icon = R.drawable.ic_fork_spoon,
        title = "Food",
        backgroundColor = Color(0xFFFFF0D2),
     Color(0xFF8A5A00)
    ),
 MiniApp(
        icon = R.drawable.ic_ticket,
        title = "Tickets",
        backgroundColor = Color(0xFFE3F4EC),
     Color(0xFF0F7B4A)
    ),
 MiniApp(
        icon = R.drawable.ic_shield,
        title = "Insurance",
        backgroundColor = Color(0xFFEEE7FB),
     Color(0xFF6B3FC9)
    ),

    )
@Composable
fun ScreenMiniApp() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Mini apps",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(start = 8.dp))
            Text(
                text = " កម្មវិធីតូច",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Explore",
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
            MiniAppList.forEach { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(item.backgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.title,
                        )

                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.title,
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
fun ScreenMiniAppPreview(){
    BankUiTheme() {
        ScreenMiniApp()

    }
}