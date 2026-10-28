package kh.com.rith.dev.bankui.data

import androidx.annotation.DrawableRes

data class MiniApp(
    @DrawableRes val icon: Int,
    val title: String,
    val backgroundColor: androidx.compose.ui.graphics.Color,
    val textColor: androidx.compose.ui.graphics.Color,
)
