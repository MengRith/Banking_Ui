package kh.com.rith.dev.bankui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.rith.dev.bankui.navigation.AppNavigation
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankUiTheme {

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                            AppNavigation()
                    }

            }
        }
    }
}

@Composable
fun HomeScreen(onAvatarClick: () -> Unit = {}) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,


    ){ paddingValues ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item { ScreenTopSection(onAvatarClick = onAvatarClick) }
            item { ScreenCardSection() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { ScreenBankService() }
            item { ScreenPromotionSection() }
            item { ScreenSchedule() }
            item { ScreenFavorite() }
            item { ScreenMiniApp() }


        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankUiTheme {
        HomeScreen{}
    }
}