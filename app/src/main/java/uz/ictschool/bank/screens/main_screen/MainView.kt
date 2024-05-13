package uz.ictschool.bank.screens.main_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.ictschool.bank.screens.home.HomeView
import uz.ictschool.bank.screens.monitoring.MonitoringView
import uz.ictschool.bank.screens.myCard.MyCardView
import uz.ictschool.bank.ui.theme.myBlue

private val screens = listOf(
    BottomNavScreens.Home,
    //BottomNavScreens.Profile,
    BottomNavScreens.Search,
    //BottomNavScreens.Message,
    BottomNavScreens.Settings,
    BottomNavScreens.Monitoring,

)

@Composable
fun MainView(navController: NavHostController){

    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White) {
                val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                screens.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = null,
                                //tint = Color.White
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(15.dp)
                               )
                               },

                        //label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            bottomNavController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(bottomNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = myBlue,
                            unselectedIconColor = Color(0xFF898989),
                            //indicatorColor = Color(0xFF3629B7)
                        ),
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(bottomNavController, startDestination = BottomNavScreens.Home.route, Modifier.padding(innerPadding)) {

            composable(BottomNavScreens.Home.route) {
                HomeView(navController = navController, vm = hiltViewModel())
            }
            composable(BottomNavScreens.Profile.route) {
                MyCardView(vm = hiltViewModel(), navController = navController)
            }
            composable(BottomNavScreens.Search.route) {
                HomeView(navController = navController, vm = hiltViewModel())
            }
            composable(BottomNavScreens.Message.route) {
                HomeView(navController = navController, vm = hiltViewModel())
            }
            composable(BottomNavScreens.Settings.route) {
                HomeView(navController = navController, vm = hiltViewModel())
            }
            composable(BottomNavScreens.Monitoring.route) {
                MonitoringView()
            }
        }
    }

}