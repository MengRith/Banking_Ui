package kh.com.rith.dev.bankui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kh.com.rith.dev.bankui.HomeScreen
import kh.com.rith.dev.bankui.account.ScreenHomeAccount
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data object Home : NavKey

@kotlinx.serialization.Serializable
data object HomeAccount : NavKey

// With arguments, just use a data class
@Serializable
data class Detail(val id: Int) : NavKey

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Home> {
                HomeScreen(
                    onAvatarClick = { backStack.add(HomeAccount) }
                )
            }
            entry<HomeAccount> {
                ScreenHomeAccount(
                    onBackClick = { backStack.removeLastOrNull() }
                )
            }

        }
    )
}
