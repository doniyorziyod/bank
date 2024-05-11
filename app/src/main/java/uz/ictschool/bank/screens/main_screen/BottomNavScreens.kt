package uz.ictschool.bank.screens.main_screen

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(val route: String, val icon: ImageVector) {
    object Home: BottomNavScreens("home", Icons.Default.Home)
    object Profile: BottomNavScreens("profile", Icons.Default.Person)
    object Search: BottomNavScreens("search", Icons.Default.Search)
    object Message: BottomNavScreens("message", Icons.Default.MailOutline)
    object Settings: BottomNavScreens("settings", Icons.Default.Settings)
    object Monitoring: BottomNavScreens("monitoring", Icons.Default.Refresh)
}