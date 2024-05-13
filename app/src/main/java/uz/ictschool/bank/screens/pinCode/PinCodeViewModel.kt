//package uz.ictschool.bank.screens.pinCode
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import dagger.hilt.android.lifecycle.HiltViewModel
//
//@HiltViewModel
//class PinCodeViewModel(): ViewModel() {
//    private var _code = MutableLiveData("")
//    val code: LiveData<String> = _code
//
//    fun addNumber(num: String){
//        _code.value+=num
//        checkCodeSize()
//    }
//
//    fun checkCodeSize(): Boolean{
//        if (_code.value!!.toCharArray().size==4){
//            return true
//        }else if (_code.value!!.toCharArray().size>4){
//            resetCode()
//        }
//        return false
//    }
//
//
//    fun resetCode(){
//        _code.value = ""
//    }
//}
