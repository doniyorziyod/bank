package uz.ictschool.bank.screens.signin

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
import uz.ictschool.bank.models.CheckCode
import uz.ictschool.bank.navigation.Screen
import javax.inject.Inject


@HiltViewModel
class CheckCodeViewModel @Inject constructor(private val model: CheckCodeModel) : ViewModel() {
    private val _code = MutableLiveData("")
    val code: LiveData<String> = _code
    private val codeLength = 6

    fun updateCode(
        new: String,
        phoneNumber: String,
        navController: NavController,
        context: Context
    ) {
        if (new.length <= 6) _code.value = new
        if (_code.value!!.length == codeLength) checkCode(phoneNumber, navController, context)
    }

    private fun checkCode(phoneNumber: String, navController: NavController, context: Context) {
        val checkCode = CheckCode(phoneNumber, code.value!!)
        viewModelScope.launch {
            val response = model.checkCode(checkCode)
            Log.d("TAG", "checkCode: ${response.status}")
            if (response.status == "Success") {
                navController.navigate(Screen.Home.route)
            }
            _code.value = ""
//            Toast.makeText(context, response.status, Toast.LENGTH_SHORT).show()
        }
    }
}
