package kh.com.rith.dev.bankui.account

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme


@Composable
fun ScreenTopAccount(
    onBackClick: () -> Unit = {}
){
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        Column {
            Text(
                text = "Account",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "គណនី",
                fontSize = 12.sp,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier

                .size(46.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ){

        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add"
        )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenTopAccountPreview(){
    BankUiTheme {
        ScreenTopAccount()
    }
}