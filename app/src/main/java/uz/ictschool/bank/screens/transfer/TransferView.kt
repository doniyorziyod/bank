package uz.ictschool.bank.screens.transfer

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import uz.ictschool.bank.R
import uz.ictschool.bank.localDataBase.AppDataBase
import uz.ictschool.bank.localDataBase.UserEntity
import uz.ictschool.bank.models.CustomTransaction
import uz.ictschool.bank.ui.theme.TransferBluePrimary
import uz.ictschool.bank.ui.theme.TransferGreyPrimary

@SuppressLint("MutableCollectionMutableState")
@Composable
fun TransferView(tvm: TransferViewModel){
    var selectedCardText = tvm.selectedCardNumber.observeAsState().value!!

    val customTransactionList = tvm.transactionList
    val beneficiaryList = tvm.beneficiaryList

    var receiver  = tvm.receiver.observeAsState().value!!
    var receiverCard = tvm.receiverCard.observeAsState().value!!
    var sendAmount = tvm.sendAmount.observeAsState().value!!
    var confirmAmount = tvm.confirmAmount.observeAsState().value!!

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
        OutlinedTextField(value = selectedCardText,
            onValueChange = {selectedCardText = it},
            readOnly = true,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = TransferGreyPrimary,
                unfocusedIndicatorColor = TransferGreyPrimary,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent),
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Available balance: 10 000$", color = TransferBluePrimary, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Choose Transaction", fontSize = 14.sp, color = TransferGreyPrimary)
        Spacer(modifier = Modifier.height(7.dp))
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(customTransactionList){
                TransactionItem(customTransaction = it, tvm = tvm)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Choose Beneficiary", color = TransferGreyPrimary, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(beneficiaryList){
                BeneficiaryItem(userEntity = it, tvm = tvm)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)) {
                InfoOutlinedEditText(onValueChange = { receiver = it }, value = receiver, keyboardType = KeyboardType.Text)
                Spacer(modifier = Modifier.height(10.dp))
                InfoOutlinedEditText(onValueChange = { receiverCard = it }, value = receiverCard, keyboardType = KeyboardType.Number)
                Spacer(modifier = Modifier.height(10.dp))
                InfoOutlinedEditText(onValueChange = { sendAmount = it }, value = sendAmount, keyboardType = KeyboardType.Number)
                Spacer(modifier = Modifier.height(10.dp))
                InfoOutlinedEditText(onValueChange = { confirmAmount = it }, value = confirmAmount, keyboardType = KeyboardType.Number)
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { tvm.onConfirmButton() }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(TransferBluePrimary)) {
                    Text(text = "Confirm", color = Color.White, fontSize = 17.sp)
                }
            }
        }
    }
}

@Composable
fun TransactionItem(customTransaction: CustomTransaction, tvm: TransferViewModel){
    val selectedTransactionType = tvm.selectedTransactionType.observeAsState().value!!

    Card(modifier = Modifier
        .height(100.dp)
        .width(120.dp)
        .clickable { tvm.onTransactionChooseButton(customTransaction.id) }, shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(
        if (customTransaction.id == selectedTransactionType) TransferBluePrimary else TransferGreyPrimary)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 12.dp, end = 10.dp, bottom = 12.dp)) {
            Icon(painter = painterResource(id = customTransaction.icon), tint = Color.White, contentDescription = "", modifier = Modifier
                .height(40.dp)
                .width(50.dp))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = customTransaction.type, maxLines = 2, color = Color.White, fontSize = 15.sp)
        }
    }
}

@Composable
fun BeneficiaryItem(userEntity: UserEntity, tvm: TransferViewModel){
    val selectedReceiver = tvm.selectedReceiver.observeAsState().value!!

    Card(modifier = Modifier
        .height(120.dp)
        .width(100.dp)
        .padding(start = 5.dp, end = 5.dp)
        .clickable { tvm.onSelectedReceiverButton(userEntity.number) }, shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(
        if (selectedReceiver.trim() == userEntity.number.trim()) TransferBluePrimary else TransferGreyPrimary)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
            AsyncImage(model = userEntity.photo,
                contentDescription = "",
                error = painterResource(id = R.drawable.default_person_ic),
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Inside)
            Text(text = userEntity.name, fontSize = 16.sp, color = if (selectedReceiver.trim() == userEntity.number.trim()) Color.White else Color.Black)
        }
    }
}

@Composable
fun InfoOutlinedEditText(onValueChange:(String)->Unit, value: String, keyboardType: KeyboardType){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedBorderColor = TransferGreyPrimary,
            unfocusedBorderColor = TransferGreyPrimary),
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}