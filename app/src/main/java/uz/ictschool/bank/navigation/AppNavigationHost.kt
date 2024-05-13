package uz.ictschool.bank.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import uz.ictschool.bank.screens.Splash
import uz.ictschool.bank.screens.Welcome
import uz.ictschool.bank.screens.addCard.AddCardView
import uz.ictschool.bank.screens.home.HomeView
import uz.ictschool.bank.screens.main_screen.MainView
import uz.ictschool.bank.screens.myCard.MyCardView
import uz.ictschool.bank.screens.signin.CheckCodeView
import uz.ictschool.bank.screens.signin.SignInView

@Composable
fun AppNavigationHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route){
            Splash(navController = navController)
        }
        composable(Screen.Welcome.route){
            Welcome(navController = navController)
        }
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
        composable(Screen.SignIn.route) {
            SignInView(vm = hiltViewModel(), navController = navController)
        }
        composable(Screen.CheckCode.route, arguments = listOf(navArgument("phone") {
            type = NavType.StringType
        })) {
            val phone = it.arguments?.getString("phone")!!
            CheckCodeView(vm = hiltViewModel(), navController = navController, phoneNumber = phone)
        }

    }
}