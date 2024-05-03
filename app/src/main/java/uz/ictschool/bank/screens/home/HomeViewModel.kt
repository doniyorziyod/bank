package uz.ictschool.bank.screens.home

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.ictschool.bank.navigation.Screen
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val model: HomeModel):ViewModel() {
    fun onCardClicked(navController: NavController) {
        navController.navigate(Screen.MyCard.route)
    }
}