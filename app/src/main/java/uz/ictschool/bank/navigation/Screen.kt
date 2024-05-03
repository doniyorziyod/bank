package uz.ictschool.bank.navigation

sealed class Screen(val route:String) {
    data object Home:Screen("home")
    data object Monitoring:Screen("monitoring")
    data object AddCard:Screen("add_card")
    data object Splash:Screen("splash")
    data object SignIn:Screen("sign_in")
    data object SignUp:Screen("sign_up")

}