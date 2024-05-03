package uz.ictschool.bank.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.ictschool.bank.screens.addCard.AddCardView
import uz.ictschool.bank.screens.home.HomeView
import uz.ictschool.bank.screens.home.HomeViewModel

@Composable
fun AppNavigationHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            HomeView(hiltViewModel())
        }
        composable(Screen.AddCard.route){
            AddCardView(vm = hiltViewModel())
        }
    }
}