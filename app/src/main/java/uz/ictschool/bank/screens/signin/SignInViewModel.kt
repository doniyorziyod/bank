package uz.ictschool.bank.screens.signin

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.ictschool.bank.models.SendCode
import uz.ictschool.bank.navigation.Screen
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val model: SignInModel) : ViewModel() {
    private var _phoneNumber = MutableLiveData("")
    val phoneNumber: LiveData<String> = _phoneNumber
    fun sendCode(navController: NavController, context: Context) {
        val phone = "+998${_phoneNumber.value}"
        val sendCode = SendCode(phone)
        viewModelScope.launch {
            val response = model.sendCode(sendCode)
            Log.d("TAG", "sendCode: ${response.status}")
            if (response.status == "Verification code sent") navController.navigate("check_code/$phone")
            Toast.makeText(context, response.status, Toast.LENGTH_SHORT).show()
        }
    }

    fun updatePhoneNUmber(new: String) {
        if (new.length < 10) _phoneNumber.value = new
    }
}