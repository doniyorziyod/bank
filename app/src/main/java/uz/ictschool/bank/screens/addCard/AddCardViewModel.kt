package uz.ictschool.bank.screens.addCard

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.ictschool.bank.MyApp
import uz.ictschool.bank.models.CheckCode
import uz.ictschool.bank.models.SendCode
import uz.ictschool.bank.utils.SharedPrefHelper
import javax.inject.Inject

@HiltViewModel
class AddCardViewModel @Inject constructor(private val model: AddCardModel) : ViewModel() {
    var sharedPrefHelper = SharedPrefHelper.getInstance(MyApp.context)
    private val _codeNumber = MutableLiveData("")
    val codeNumber: LiveData<String> = _codeNumber

    private val _cardNumber = MutableLiveData("")
    val cardNumber: LiveData<String> = _cardNumber

    private var _state = MutableLiveData(false)
    var state: LiveData<Boolean> = _state

    var status = ""

    fun updateCardNumber(new: String) {
        _cardNumber.value = new
    }

    fun updateCodeNumber(new: String) {
        _codeNumber.value = new
    }

    fun sendCode() {
        if (enableDisable()) {
            viewModelScope.launch {
                val sendCode = SendCode("+998906446151")
                Log.d("TAG", model.sendCode(sendCode).status)
            }
        }
        else Toast.makeText(MyApp.context, "card number too short", Toast.LENGTH_SHORT).show()
    }

    fun enableDisable(): Boolean {
        if (cardNumber.value!!.length == 16) {
            return true
        }
        return false
    }

    fun checkCode(code: String) {
        viewModelScope.launch {
            val checkCode = CheckCode("+998906446151", code)
            status = model.checkCode(checkCode).status
            Log.d("TAG", "checkCode: ${model.checkCode(checkCode).status}")
//            if (state.)
        }
    }

    fun backClick(navController: NavController) {
        navController.popBackStack()
    }
}