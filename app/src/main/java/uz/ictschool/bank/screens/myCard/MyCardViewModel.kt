package uz.ictschool.bank.screens.myCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.ictschool.bank.MyApp
import uz.ictschool.bank.localDataBase.AppDataBase
import uz.ictschool.bank.models.Card
import uz.ictschool.bank.models.User
import uz.ictschool.bank.navigation.Screen
import uz.ictschool.bank.utils.SharedPrefHelper
import javax.inject.Inject

@HiltViewModel
class MyCardViewModel @Inject constructor(val model: MyCardModel) : ViewModel() {

    var db = AppDataBase.getInstance(MyApp.context)

    fun backButtonClick(navController: NavController) {
        navController.popBackStack()
    }

    fun getCard(): Card {
        if (db.getCardDao().getMyCards().isNullOrEmpty()){
            return Card(0,0,"you dont have card yet to create one tap here","","","")
        }
        return db.getCardDao().getMyCards().last()
    }

    fun getAllCards(): List<Card> {
        return db.getCardDao().getMyCards()
    }

    init {

    }

}