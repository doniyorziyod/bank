package uz.ictschool.bank.screens.myCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import uz.ictschool.bank.screens.home.MyCardView

@Composable
fun MyCardView(vm: MyCardViewModel, navController: NavHostController) {
    Scaffold(topBar = { TopBar(vm, navController) }) {
        Column(Modifier.padding(top = it.calculateTopPadding(), start = 16.dp, end = 16.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            MyCardView(onClick = {})
            AddCardButton(onclick = {vm.backButtonClick(navController)})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardButton(onclick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(Color(0xFFD3D3D3)), onClick = onclick) {
        Text(
            text = "+ Add Card",
            color = Color(0xFF6B6B6B),
            modifier = Modifier
                .padding(vertical = 6.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TopBar(vm: MyCardViewModel, navController: NavController) {
    TopAppBar(title = { Text(text = "My cards", fontWeight = FontWeight.W500) }, navigationIcon = {
        IconButton(onClick = { vm.backButtonClick(navController) }) {
            Icon(Icons.Rounded.KeyboardArrowLeft, contentDescription = "")
        }
    }, backgroundColor = Color.White, contentColor = Color(0xFF121212))
}
