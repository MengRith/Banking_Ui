package kh.com.rith.dev.bankui.data

data class Account(
    val id: Int,
    val name: String,
    val currency: Currency,
    val last4: String,
    val balance: Double
)