package uz.ictschool.bank.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun HomeView() {
    val name = "Push Put"
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF3629B7))
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                Icons.Rounded.AccountCircle,
                contentDescription = "",
                modifier = Modifier.size(42.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Hi, $name", color = Color.White, modifier = Modifier.weight(1f))
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Card(
            Modifier.weight(1f),
            shape = RoundedCornerShape(24.dp, 24.dp),
            colors = CardDefaults.cardColors(
                Color.White
            )
        ) {
            HomeContent()
        }
        val selected = remember {
            mutableIntStateOf(0)
        }
        BottomNavigation(backgroundColor = Color.White, elevation = 1.dp) {
            NavigationBarItem(
                selected = selected.intValue == 0,
                onClick = { if (selected.intValue != 0) selected.intValue = 0 },
                icon = {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = ""
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color(0xFF898989),
                    indicatorColor = Color(0xFF3629B7)
                )
            )
            NavigationBarItem(
                selected = selected.intValue == 1,
                onClick = { if (selected.intValue != 1) selected.intValue = 1 },
                icon = {
                    Icon(
                        Icons.Rounded.Search,
                        contentDescription = ""
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color(0xFF898989),
                    indicatorColor = Color(0xFF3629B7)
                )
            )
            NavigationBarItem(
                selected = selected.intValue == 2,
                onClick = { if (selected.intValue != 2) selected.intValue = 2 },
                icon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = ""
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color(0xFF898989),
                    indicatorColor = Color(0xFF3629B7)
                )
            )
            NavigationBarItem(
                selected = selected.intValue == 3,
                onClick = { if (selected.intValue != 3) selected.intValue = 3 },
                icon = {
                    Icon(
                        Icons.Rounded.Settings,
                        contentDescription = ""
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color(0xFF898989),
                    indicatorColor = Color(0xFF3629B7)
                )
            )

        }
    }
}

@Composable
fun HomeContent() {
    CardView()
    Services()
}

@Composable
fun Services() {
    val services = listOf(
        Service("Credit Card", Icons.Rounded.AccountBox, Color(0xFFFF5722)),
        Service("Account and Card", Icons.Rounded.DateRange, Color(0xFF8BC34A)),
        Service("Withdraw", Icons.Rounded.Notifications, Color(0xFF2196F3)),
        Service("Transfer", Icons.Rounded.Face, Color(0xFF673AB7)),
        Service("Credit Card", Icons.Rounded.AccountBox, Color(0xFFFF5722)),
        Service("Withdraw", Icons.Rounded.Notifications, Color(0xFF2196F3)),
        Service("Credit Card", Icons.Rounded.AccountBox, Color(0xFFFF5722)),
    )
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(services) {
            ServiceItem(it)
        }
    }
}

@Composable
fun ServiceItem(service: Service) {
    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(1.dp, 0.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 4.dp)
        ) {
            Icon(
                service.imageVector,
                contentDescription = "",
                modifier = Modifier.size(36.dp),
                tint = service.color
            )
            Text(text = service.name, color = Color(0xFF979797), textAlign = TextAlign.Center)
        }
    }

}

data class Service(val name: String, val imageVector: ImageVector, val color: Color)

@Composable
fun CardView() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.6f)
            .padding(18.dp),
        colors = CardDefaults.cardColors(Color(0xFF1573FF)), shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .padding(horizontal = 18.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "John Smith", color = Color.White, fontSize = 22.sp)
            Column {
                Text(text = "Amazon Platinum", color = Color.White, fontSize = 16.sp)
                Text(text = "4756 •••• •••• 9018", color = Color.White, fontSize = 22.sp)
                Text(text = "$ 3 469.45", color = Color.White, fontSize = 22.sp)
            }
        }
    }

}