package uz.ictschool.bank.screens.addCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun AddCardView(vm: AddCardViewModel) {
    val phoneNumber = vm.phoneNumber.observeAsState().value!!
    Column(Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { vm.updatePhoneNumber(it) },
            modifier = Modifier.fillMaxWidth()
        )
        TextButton(
            onClick = { vm.sendCode() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.textButtonColors(
                Color(0xFF0077F5)
            )
        ) {
            Text(text = "Send code", color = Color.White)
        }
    }
}