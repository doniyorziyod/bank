package uz.ictschool.bank.screens.transfer.confirm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ConfirmViewModel(private val navController: NavController, context: Context): ViewModel() {

    private val _fromCard = MutableLiveData("")
    val fromCard: LiveData<String> = _fromCard

    private val _toName = MutableLiveData("")
    val toName: LiveData<String> = _toName

    private val _content = MutableLiveData("")
    val content: LiveData<String> = _content

}