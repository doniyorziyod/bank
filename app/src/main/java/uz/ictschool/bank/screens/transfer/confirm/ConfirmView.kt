package uz.ictschool.bank.screens.transfer.confirm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.ictschool.bank.screens.transfer.InfoOutlinedEditText
import uz.ictschool.bank.ui.theme.TransferBluePrimary
import uz.ictschool.bank.ui.theme.TransferGreyPrimary

@Composable
fun ConfirmView(cvm: ConfirmViewModel){
    var fromCard = cvm.fromCard.observeAsState().value!!
    var toName = cvm.toName.observeAsState().value!!
    var content = cvm.content.observeAsState().value!!
    
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .verticalScroll(rememberScrollState())) {
        TopAppBar(title = { Text(text = "Transfer") }, navigationIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null
            )
        })
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Confirm transaction information", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "From", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(4.dp))
        InfoOutlinedEditText(onValueChange = {fromCard = it}, value = fromCard, keyboardType = KeyboardType.Number)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "To", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(4.dp))
        InfoOutlinedEditText(onValueChange = {toName = it}, value = toName, keyboardType = KeyboardType.Text)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Transaction fee", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(4.dp))
        InfoOutlinedEditText(onValueChange = {toName = it}, value = toName, keyboardType = KeyboardType.Number)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Content", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(4.dp))
        InfoOutlinedEditText(onValueChange = {content = it}, value = content, keyboardType = KeyboardType.Text)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Amount", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(4.dp))
        InfoOutlinedEditText(onValueChange = {content = it}, value = content, keyboardType = KeyboardType.Number)
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "Get OTP to verify transaction", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = toName,
                onValueChange = { toName = it },
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedBorderColor = TransferGreyPrimary,
                    unfocusedBorderColor = TransferGreyPrimary),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(onClick = {  },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    if (toName.isNotEmpty()) TransferBluePrimary else TransferGreyPrimary)
            ) {
                Text(text = "Get OTP", color = Color.White, fontSize = 17.sp)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(TransferBluePrimary)) {
            Text(text = "Confirm", fontSize = 17.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}