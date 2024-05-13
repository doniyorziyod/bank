package uz.ictschool.bank.screens.transfer

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.ictschool.bank.R
import uz.ictschool.bank.localDataBase.AppDataBase
import uz.ictschool.bank.models.CustomTransaction
import uz.ictschool.bank.navigation.Screen
import javax.inject.Inject

@HiltViewModel
class TransferViewModel @Inject constructor(val model: TransferModel, @ApplicationContext context: Context) :ViewModel(){

    private val dao = AppDataBase.getInstance(context).getUserDao()

    private val _selectedCardNumber = MutableLiveData("")
    val selectedCardNumber: LiveData<String> = _selectedCardNumber

    private val _selectedReceiver = MutableLiveData("")
    val selectedReceiver: LiveData<String> = _selectedReceiver

    private val _selectedTransactionType = MutableLiveData(0)
    val selectedTransactionType: LiveData<Int> = _selectedTransactionType

    val beneficiaryList = dao.getAllUsers()

    init {
        _selectedTransactionType.value = 1
    }

    val transactionList = mutableListOf<CustomTransaction>(
        CustomTransaction(1, R.drawable.creditcard_ic, "Transfer via card number"),
        CustomTransaction(2, R.drawable.person_ic, "Transfer to the same bank"),
        CustomTransaction(3, R.drawable.bank_ic, "Transfer to another bank")
    )

    private val _receiver = MutableLiveData("")
    val receiver: LiveData<String> = _receiver

    private val _receiverCard = MutableLiveData("")
    val receiverCard: LiveData<String> = _receiverCard

    private val _sendAmount = MutableLiveData("")
    val sendAmount: LiveData<String> = _sendAmount

    private val _confirmAmount = MutableLiveData("")
    val confirmAmount: LiveData<String> = _confirmAmount

    fun onConfirmButton(navController: NavController){
        navController.navigate(Screen.Confirm.route)
    }

    fun onTransactionChooseButton(id: Int){
        _selectedTransactionType.value = id
    }

    fun onSelectedReceiverButton(card: String){
        _selectedReceiver.value = card
    }
}
