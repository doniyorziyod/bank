package uz.ictschool.bank.screens.main_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import uz.ictschool.bank.R

sealed class BottomNavScreens(val route: String, val icon: ImageVector) {
    object Home: BottomNavScreens("home", Icons.Sharp.Home)
    object Profile: BottomNavScreens("profile", Icons.Default.Person)
    object Search: BottomNavScreens("search", Icons.Default.Search)
    object Message: BottomNavScreens("message", Icons.Default.MailOutline)
    object Settings: BottomNavScreens("settings", Icons.Default.Settings)
    object Monitoring: BottomNavScreens("monitoring", Icons.Sharp.Refresh)
    //object Payment: BottomNavScreens("payment", )
}