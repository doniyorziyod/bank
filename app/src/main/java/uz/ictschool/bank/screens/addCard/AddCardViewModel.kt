package uz.ictschool.bank.screens.addCard

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val _phoneNumber = MutableLiveData("")
    val phoneNumber: LiveData<String> = _phoneNumber

    fun updatePhoneNumber(new: String) {
        _phoneNumber.value = new
    }

    fun sendCode() {
        viewModelScope.launch {
            val sendCode = SendCode(sharedPrefHelper.getUserNumber()!!)
            Log.d("TAG", model.sendCode(sendCode).status)
        }
    }

    fun checkCode(code:String){
        viewModelScope.launch {
            val checkCode = CheckCode(sharedPrefHelper.getUserNumber()!!,code)
            Log.d("TAG", model.checkCode(checkCode).status)
        }
    }
}
