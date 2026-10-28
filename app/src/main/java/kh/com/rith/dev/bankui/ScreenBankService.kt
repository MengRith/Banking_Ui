package kh.com.rith.dev.bankui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.data.Services
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme


val ServicesList = listOf(
    Services(
        icon = R.drawable.ic_right_left_arrow,
        titleEnglish = "Transfer",
        titleKhmer = "ផ្ទេរ"
    ),

    Services(
        icon = R.drawable.ic_receipt,
        titleEnglish = "Pay Bill",
        titleKhmer = "បង់វិក្កយបត្រ"
    ),

    Services(
        icon = R.drawable.ic_mobile,
        titleEnglish = "Top Up",
        titleKhmer = "បញ្ចូលទីកប្រាក់"
    ),

    Services(
        icon = R.drawable.ic_qr_code,
        titleEnglish = "Scan QR",
        titleKhmer = "ស្កេន"
    ),Services(
        icon = R.drawable.ic_paid,
        titleEnglish = "Loan",
        titleKhmer = "កម្ចី"
    ),

    Services(
        icon = R.drawable.ic_credit_card,
        titleEnglish = "Card",
        titleKhmer = "កាត់"
    ),

    Services(
        icon = R.drawable.ic_right_left_arrow,
        titleEnglish = "Exchange",
        titleKhmer = "ប្ដូរប្រាក់"
    ),

    Services(
        icon = R.drawable.ic_more_horiz,
        titleEnglish = "More",
        titleKhmer = "ផ្សេងៗ"
    ),


    )

@Composable
fun ScreenBankService(

) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Banking services",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "សេវាធនាគារ",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.surface)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(vertical = 16.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ServicesList.chunked(4).forEach { rowItems ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    rowItems.forEach { item ->
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(RoundedCornerShape(18.dp))
                                    .background(MaterialTheme.colorScheme.secondaryContainer)
                                    .clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = item.titleEnglish,
                                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier.size(22.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = item.titleEnglish,
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1
                            )
                            Text(
                                text = item.titleKhmer,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 10.sp,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenBankServicePreview() {
    BankUiTheme() {
        ScreenBankService()
    }
}