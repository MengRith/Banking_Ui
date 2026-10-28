package kh.com.rith.dev.bankui.account

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme

@Composable
fun ScreenHomeAccount(
    onBackClick: () -> Unit = {}
){
    Scaffold(

    ){paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item { ScreenTopAccount(onBackClick = onBackClick) }
            item { ScreenCardAccount() }
            item { ScreenFinance() }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun ScreenHomeAccountPreview(){
    BankUiTheme {
        ScreenHomeAccount()
    }
}