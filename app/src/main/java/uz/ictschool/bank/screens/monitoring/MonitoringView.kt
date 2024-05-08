package uz.ictschool.bank.screens.monitoring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MonitoringView() {
    val name = "John Smith"
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3629B7)), topBar = {
            TopBar()
        }, containerColor = Color(0xFF3629B7)
    ) {
        Column(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            Box(Modifier.fillMaxSize()) {
                Column(Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.weight(1f))
                    Card(
                        Modifier
                            .fillMaxWidth()
                            .weight(7f),
                        shape = RoundedCornerShape(24.dp, 24.dp),
                        colors = CardDefaults.cardColors(
                            Color.White
                        )
                    ) {}
                }
                Column(Modifier.padding(horizontal = 16.dp)) {
                    CreditCard()
                    IncomeExpense()
                }
            }
        }
    }
}

@Composable
fun IncomeExpense() {
    Column {
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Today", color = Color(0xFF979797), fontWeight = FontWeight.W600)

        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        IncomeExpenseItem(true, "Water bill", "UzSuvTa'minot", "$230", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        Text(text = "Yesterday", color = Color(0xFF979797), fontWeight = FontWeight.W600)
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        IncomeExpenseItem(true, "Water bill", "UzSuvTa'minot", "$300", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$400", "12:10")
        IncomeExpenseItem(true, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$500", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$200", "12:10")
        IncomeExpenseItem(false, "Water bill", "UzSuvTa'minot", "$100", "12:10")
        IncomeExpenseItem(true, "Water bill", "UzSuvTa'minot", "$120", "12:10")

    }
}

@Composable
fun IncomeExpenseItem(
    isIncome: Boolean, name: String, fromTo: String, amount: String, time: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(
            vertical = 6.dp
        )
    ) {
        Card(colors = CardDefaults.cardColors(Color(0xFF0890FE))) {
            Column(Modifier.padding(8.dp)) {
                Icon(
                    imageVector = Icons.Rounded.Build,
                    contentDescription = "",
                    Modifier.size(22.dp),
                    tint = Color.White
                )
            }
        }
        Column(
            Modifier
                .padding(horizontal = 12.dp)
                .weight(1f)
        ) {
            Text(text = name, fontWeight = FontWeight.W400)
            Text(text = fromTo, fontWeight = FontWeight.W900, color = Color(0xFFBDBDBD), fontSize = 12.sp)
        }
        Text(
            text = if (isIncome) "+ $amount" else "- $amount",
            fontWeight = FontWeight.W800,
            fontSize = 18.sp,
            color = if (isIncome) Color(0xFF4CAF50) else Color(0xFFFF4267)
        )
    }
}

@Composable
fun CreditCard() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.6f),
            colors = CardDefaults.cardColors(Color(0xFF1E1671)),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 18.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "John Smith",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W600
                )
                Column {
                    Text(text = "Amazon Platinum", color = Color.White, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "4756 •••• •••• 9018", color = Color.White, fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "$ 3 469.52",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W900
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(8.dp),
            colors = CardDefaults.cardColors(Color(0xFFFF5722)),
            shape = RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp)
        ) { Text(text = "") }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .height(8.dp),
            colors = CardDefaults.cardColors(Color(0xFF5655B9)),
            shape = RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp)
        ) { Text(text = "") }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Transaction report", fontWeight = FontWeight.W500) },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        modifier = Modifier.padding(vertical = 8.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            Color(0xFF3629B7),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )
}
