package uz.ictschool.bank.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.ictschool.bank.screens.addCard.AddCardView
import uz.ictschool.bank.screens.home.HomeView
import uz.ictschool.bank.screens.main_screen.MainView
import uz.ictschool.bank.screens.myCard.MyCardView

@Composable
fun AppNavigationHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Main.route){
        composable(Screen.Home.route){
            HomeView(hiltViewModel(), navController)
        }
        composable(Screen.Main.route){
            MainView(navController = navController)
        }
        composable(Screen.AddCard.route){
            AddCardView(vm = hiltViewModel(),navController)
        }
        composable(Screen.MyCard.route){
            MyCardView(vm = hiltViewModel(), navController)
        }
    }
}