package uz.ictschool.bank.screens.addCard

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.ictschool.bank.R
import uz.ictschool.bank.ui.theme.cardColor
import uz.ictschool.bank.ui.theme.cardColorSecondary
import uz.ictschool.bank.ui.theme.gray


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AddCardView(vm: AddCardViewModel, navController: NavController) {
    val codeNumber = vm.codeNumber.observeAsState().value!!
    val cardNumber = vm.cardNumber.observeAsState().value!!
//    Column(Modifier.fillMaxSize()) {
//        OutlinedTextField(
//            value = phoneNumber,
//            onValueChange = { vm.updatePhoneNumber(it) },
//            modifier = Modifier.fillMaxWidth()
//        )
//        TextButton(
//            onClick = { vm.sendCode() },
//            modifier = Modifier.fillMaxWidth(),
//            colors = ButtonDefaults.textButtonColors(
//                Color(0xFF0077F5)
//            )
//        ) {
//            Text(text = "Send code", color = Color.White)
//        }
//    }

    Scaffold(topBar = { TopBar(vm, navController) }) {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.img), contentDescription = "img",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .size(200.dp),
//                contentScale = ContentScale.Crop

            )

            Spacer(modifier = Modifier.height(70.dp))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = gray,
                    unfocusedBorderColor = cardColorSecondary,
                    focusedBorderColor = cardColor,
                    focusedTextColor = Color.Black,
                    unfocusedLabelColor = gray,
                    focusedLabelColor = cardColor
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = {
                    IconButton(
                        onClick = { vm.sendCode() },

                        ) {
                        Icon(
                            imageVector = Icons.Outlined.Send,
                            contentDescription = "Back",
                            tint = gray
                        )
                    }
                },
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                value = cardNumber,
                label = { Text("card number") },
                onValueChange = { if (it.length <= 16) vm.updateCardNumber(it) },
            )

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = gray,
                    unfocusedBorderColor = cardColorSecondary,
                    focusedBorderColor = cardColor,
                    focusedTextColor = Color.Black,
                    unfocusedLabelColor = gray,
                    focusedLabelColor = cardColor
                ),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                value = codeNumber,
                label = { Text("your code from telegramm") },
                onValueChange = { if (it.length <= 6) vm.updateCodeNumber(it) },
            )

            Spacer(modifier = Modifier.height(50.dp))
            androidx.compose.material3.TextButton(
                enabled = vm.enableDisable(), // hali ozgartiramiz
                onClick = {
                    Log.d("TAG", "AddCardView: check+${codeNumber}")
//                    vm.checkCode(codeNumber)
                    vm.addCard(codeNumber,cardNumber)
                },
                colors = androidx.compose.material3.ButtonDefaults.textButtonColors(
                    containerColor = cardColor,
                    disabledContainerColor = cardColorSecondary
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Check code", color = Color.White, fontSize = 17.sp)

            }
        }
    }
}

@Composable
fun TopBar(vm: AddCardViewModel, navController: NavController) {
    TopAppBar(title = {
        androidx.compose.material3.Text(
            text = "Add card",
            fontWeight = FontWeight.W500
        )
    }, navigationIcon = {
        IconButton(onClick = { vm.backClick(navController) }) {
            Icon(Icons.Rounded.KeyboardArrowLeft, contentDescription = "")
        }
    }, backgroundColor = Color.White, contentColor = Color(0xFF121212))
}