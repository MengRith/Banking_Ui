package kh.com.rith.dev.bankui.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme
import kh.com.rith.dev.bankui.ui.theme.CardBg
import kh.com.rith.dev.bankui.ui.theme.InnerBg
import kh.com.rith.dev.bankui.ui.theme.MutedText

@Composable
fun ScreenCardAccount() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        color = CardBg
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Total balance · សមតុល្យសរុប",
                color = MutedText,
                fontSize = 15.sp
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "$12,480.50",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = InnerBg
                ) {
                    Column(
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 14.dp))
                    {
                        Text(
                            text = "USA",
                            color = MutedText,
                            fontSize = 14.sp)
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = "$15,695.50",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = InnerBg
                ) {
                    Column(
                        modifier = Modifier.padding(
                            horizontal = 16.dp, vertical = 14.dp))
                    {
                        Text(
                            text = "USA",
                            color = MutedText,
                            fontSize = 14.sp)
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = "៛29,780,000",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }

            Spacer(Modifier.height(18.dp))
            Text(
                text = $$"Converted at $1 = ៛4,000 (sample rate)",
                color = MutedText,
                fontSize = 14.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ScreenCardAccountPreview(){
    BankUiTheme {
        ScreenCardAccount()
    }
}