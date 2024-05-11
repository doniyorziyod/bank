package uz.ictschool.bank.screens.home

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.ictschool.bank.MyApp
import uz.ictschool.bank.localDataBase.AppDataBase
import uz.ictschool.bank.models.Card
import uz.ictschool.bank.navigation.Screen
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val model: HomeModel):ViewModel() {
    val db = AppDataBase.getInstance(MyApp.context)
    fun onCardClicked(navController: NavController) {
        navController.navigate(Screen.MyCard.route)
    }
    fun getCard(): Card {
        if (db.getCardDao().getMyCards().isNullOrEmpty()){
            return Card(0,0,"\n\nyou dont have card yet to create one tap here","","","")
        }
        return db.getCardDao().getMyCards().last()
    }
}