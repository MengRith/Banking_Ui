package kh.com.rith.dev.bankui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme
import kh.com.rith.dev.bankui.ui.theme.Black
import kh.com.rith.dev.bankui.ui.theme.White


@Composable
fun ScreenTopSection(
    onAvatarClick: () -> Unit = {},
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Box(
            modifier = Modifier
                .clip( shape = CircleShape)
                .size(64.dp)
                .background(Black)
                .clickable {
                    onAvatarClick()
                }
                .padding(8.dp),
            contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "MR",
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

        }

        Column(
            modifier = Modifier
                .padding(8.dp),

        ) {
            Text(
                text = "សួស្ដី - Good Morning",
                fontSize = 12.sp,
            )
            Text (
                    text = "Meng Rith",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                    )

        }

        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(44.dp)
                .shadow(elevation = 3.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(Color.White)
                .clickable {},
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Notification",
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 11.dp, end = 12.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.error)
            )
        }
    }
}

@Preview
@Composable
fun ScreenTopSectionPreview() {
    BankUiTheme {
        ScreenTopSection{}
    }
}