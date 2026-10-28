package kh.com.rith.dev.bankui

import android.R.attr.fontWeight
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.data.Promotion
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme
import kh.com.rith.dev.bankui.ui.theme.BlueEnd
import kh.com.rith.dev.bankui.ui.theme.BlueStart
import kh.com.rith.dev.bankui.ui.theme.GreenEnd
import kh.com.rith.dev.bankui.ui.theme.GreenStart
import kh.com.rith.dev.bankui.ui.theme.OrangeEnd
import kh.com.rith.dev.bankui.ui.theme.OrangeStart
import kh.com.rith.dev.bankui.ui.theme.PurpleEnd
import kh.com.rith.dev.bankui.ui.theme.PurpleStart


val PromotionList = listOf(
    Promotion(
        title = "0% fee transfer",
        description = "ផ្ទេរមិនគិតកម្រែ Unit Oct 32",
        color = getGradient(
            BlueStart,
            BlueEnd
        )
    ),


        Promotion(
        title = "Earn 4.5% Saving",
        description = "ការប្រាក់សន្សំបៀរ",
        color = getGradient(
            PurpleStart,
            PurpleEnd
        )
    ),


        Promotion(
        title = "0% fee transfer",
        description = "ផ្ទេរមិនគិតកម្រែ Unit Oct 32",
        color = getGradient(
            GreenStart,
            GreenEnd
        )
    ),


        Promotion(
        title = "0% fee transfer",
        description = "ផ្ទេរមិនគិតកម្រែ Unit Oct 32",
        color = getGradient(
            OrangeStart,
            OrangeEnd
        )
    ),



)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun ScreenPromotionSection(){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row() {
            Text(
                text = "Promotions",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(start = 8.dp))
             Text(
                text = " - ប្រូម៉ូលសិន",
                 color = MaterialTheme.colorScheme.onSurfaceVariant,
                 fontSize = 12.sp
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See all",
                color = Color.Blue

            )
        }

        Spacer(modifier = Modifier.padding(16.dp))
        LazyRow() {
            items(PromotionList.size) { index ->
                PromotionItem(index)
            }
        }
    }
}

@Composable
fun PromotionItem(
    index: Int
) {
    val card = PromotionList[index]
    var itemPaddingEnd = 0.dp
    if (index == PromotionList.size - 1) {
        itemPaddingEnd = 16.dp
    }


    Box(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = itemPaddingEnd,
            )
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(card.color)
                .width(300.dp)
                .height(150.dp)
                .clickable {}
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = card.title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.description,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}





@Preview(showBackground = true)
@Composable
fun ScreenPromotionSectionPreview(){
    BankUiTheme() {
        ScreenPromotionSection()
    }
}