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
import uz.ictschool.bank.models.User
import uz.ictschool.bank.navigation.Screen
import uz.ictschool.bank.utils.SharedPrefHelper
import javax.inject.Inject

@HiltViewModel
class MyCardViewModel @Inject constructor(val model: MyCardModel) : ViewModel() {

    var sharedPrefHelper = SharedPrefHelper.getInstance(MyApp.context)


    private var _cards = MutableStateFlow<List<User>>(emptyList())
    var cards: StateFlow<List<User>> = _cards

    fun backButtonClick(navController: NavController) {
        navController.navigate(Screen.AddCard.route)
    }

    fun getCards() {
        viewModelScope.launch {
            _cards.value = model.getCards()
        }
    }

    fun getMyCard(card_num:String){
        viewModelScope.launch {
            model.getCardsByNUmber(card_num)
        }
    }




    init {

    }

}