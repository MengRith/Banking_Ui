package kh.com.rith.dev.bankui.account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.data.Account
import kh.com.rith.dev.bankui.data.AccountFilter
import kh.com.rith.dev.bankui.data.Currency
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme
import kh.com.rith.dev.bankui.ui.theme.Border
import kh.com.rith.dev.bankui.ui.theme.KhrIconBg
import kh.com.rith.dev.bankui.ui.theme.KhrIconTint
import kh.com.rith.dev.bankui.ui.theme.Muted
import kh.com.rith.dev.bankui.ui.theme.Navy
import kh.com.rith.dev.bankui.ui.theme.ScreenBg
import kh.com.rith.dev.bankui.ui.theme.UsdIconBg
import kh.com.rith.dev.bankui.ui.theme.UsdIconTint
import java.util.Locale

private val sampleAccounts = listOf(
    Account(1, "Savings · សន្សំ", Currency.USD, "4821", 12480.50),
    Account(2, "Current · ចរន្ត", Currency.USD, "7305", 3215.00),
    Account(3, "Savings · សន្សំ", Currency.KHR, "1190", 25_600_000.0),
    Account(4, "Current · ចរន្ត", Currency.KHR, "6642", 4_180_000.0),
)

private fun Account.formattedBalance(): String = when (currency) {
    Currency.USD -> String.format(Locale.US, "$%,.2f", balance)
    Currency.KHR -> String.format(Locale.US, "៛%,.0f", balance)
}

@Composable
fun ScreenFinance(
    modifier: Modifier = Modifier,
    accounts: List<Account> = sampleAccounts,
) {
    AccountsScreen(
        modifier = modifier,
        accounts = accounts,
    )
}

@Composable
fun AccountsScreen(
    modifier: Modifier = Modifier,
    accounts: List<Account> = sampleAccounts,
) {
    var filter by remember { mutableStateOf(AccountFilter.ALL) }

    val usdAccounts = accounts.filter { it.currency == Currency.USD }
    val khrAccounts = accounts.filter { it.currency == Currency.KHR }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBg),
    ) {
        FilterRow(
            selected = filter,
            onSelected = { filter = it },
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp),
        )

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            if (filter != AccountFilter.KHR && usdAccounts.isNotEmpty()) {
                item {
                    SectionHeader(
                        title = "US DOLLAR · ដុល្លារអាមេរិក",
                        count = usdAccounts.size,
                    )
                }
                items(usdAccounts, key = { it.id }) { AccountCard(it) }
            }

            if (filter != AccountFilter.USD && khrAccounts.isNotEmpty()) {
                item {
                    Spacer(Modifier.height(6.dp))
                    SectionHeader(
                        title = "KHMER RIEL · រៀលកម្ពុជា",
                        count = khrAccounts.size,
                    )
                }
                items(khrAccounts, key = { it.id }) { AccountCard(it) }
            }
        }
    }
}

@Composable
private fun FilterRow(
    selected: AccountFilter,
    onSelected: (AccountFilter) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        AccountFilter.entries.forEach { item ->
            FilterPill(
                text = item.label,
                selected = item == selected,
                onClick = { onSelected(item) },
            )
        }
    }
}

@Composable
private fun FilterPill(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val shape = CircleShape
    Box(
        modifier = Modifier
            .clip(shape)
            .background(if (selected) Navy else Color.White)
            .border(
                BorderStroke(1.dp, if (selected) Navy else Border),
                shape,
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 26.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else Navy,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
private fun SectionHeader(
    title: String,
    count: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            color = Muted,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = if (count == 1) "1 account" else "$count accounts",
            color = Muted,
            fontSize = 14.sp,
        )
    }
}

@Composable
private fun AccountCard(account: Account) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Border),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CurrencyIcon(account.currency)

            Spacer(Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = account.name,
                    color = Navy,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "${account.currency.name} •••• ${account.last4}",
                    color = Muted,
                    fontSize = 14.sp,
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = account.formattedBalance(),
                    color = Navy,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "Available",
                    color = Muted,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Composable
private fun CurrencyIcon(currency: Currency) {
    val (bg, tint) = when (currency) {
        Currency.USD -> UsdIconBg to UsdIconTint
        Currency.KHR -> KhrIconBg to KhrIconTint
    }
    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(CircleShape)
            .background(bg),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = currency.symbol,
            color = tint,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenFinancePreview() {
    BankUiTheme {
        ScreenFinance()
    }
}
