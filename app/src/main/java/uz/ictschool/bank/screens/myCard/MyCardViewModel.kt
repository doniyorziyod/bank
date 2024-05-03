package uz.ictschool.bank.screens.myCard

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.ictschool.bank.navigation.Screen
import javax.inject.Inject

@HiltViewModel
class MyCardViewModel @Inject constructor(val model: MyCardModel) : ViewModel() {
    fun backButtonClick(navController: NavController) {
        navController.navigate(Screen.AddCard.route)
    }

}