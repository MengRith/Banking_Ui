package kh.com.rith.dev.bankui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.rith.dev.bankui.data.Schedule
import kh.com.rith.dev.bankui.ui.theme.BankUiTheme

val scheduleList = listOf(
    Schedule("Oct", "20", "Rent", "Standing order", "-$350.00"),
    Schedule("Oct", "25", "Electricity bill", "Auto pay", "-៛186,500"),
    Schedule("Nov", "01", "Loan repayment", "Due in 16 days", "-$200.00"),
)
@Composable
fun ScreenSchedule()
{
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Schedule",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(start = 8.dp))
            Text(
                text = " - ការវិភាគ",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See all",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Blue

            )
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(24.dp)
                )
                .background(MaterialTheme.colorScheme.surface),


        ) {
            scheduleList.forEachIndexed { index, schedule ->
                ScheduleItem(schedule)
                if (index < scheduleList.lastIndex) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                }
            }
        }
    }
}

@Composable
fun ScheduleItem(
    schedule: Schedule
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(
                    horizontal = 12.dp,
                    vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = schedule.month,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = schedule.day,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = schedule.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = schedule.description,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }


        Text(
            text = schedule.price,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
}


@Preview(showBackground = true)
@Composable
fun ScreenSchedulePreview(){
    BankUiTheme() {
        ScreenSchedule()
    }
}
