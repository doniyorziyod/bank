package uz.ictschool.bank.screens.addCard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.ictschool.bank.models.SendCode
import javax.inject.Inject

@HiltViewModel
class AddCardViewModel @Inject constructor(val addCardModel: AddCardModel) : ViewModel() {
    private val _phoneNumber = MutableLiveData("")
    val phoneNumber: LiveData<String> = _phoneNumber

    fun updatePhoneNumber(new: String) {
        _phoneNumber.value = new
    }

    fun sendCode() {
        viewModelScope.launch {
            val sendCode = SendCode("+998901234567")
            Log.d("TAG", addCardModel.sendCode(sendCode).status)
        }
    }
}