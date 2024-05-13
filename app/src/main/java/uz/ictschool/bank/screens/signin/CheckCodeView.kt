package uz.ictschool.bank.screens.signin

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.ictschool.bank.R
import uz.ictschool.bank.ui.theme.ColorField

@Composable
fun CheckCodeView(vm: CheckCodeViewModel, navController: NavController, phoneNumber:String){
    val codeNumber = vm.code.observeAsState().value!!
    val context = LocalContext.current
    val bacDispatcher=LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize(), ){
        Column (
            Modifier
                .background(Color.White)
                .fillMaxSize()){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp)
            ) {
                IconButton(onClick = { bacDispatcher?.onBackPressed() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = "",
                        Modifier.size(22.dp),
                        tint = Color.Black
                    )

                }

                Text(
                    text = "Forgot Password",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Row {
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = "Type a code", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(15.dp))
                TextField (
                    value = codeNumber,
                    onValueChange = { vm.updateCode(it, phoneNumber, navController, context) },
                    placeholder = { Text(text = "Code") },
                    textStyle =
                    TextStyle(color = Color.Black, fontSize = 15.sp),
                    singleLine = true,
                    shape = RoundedCornerShape(24.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = ColorField,
                        unfocusedContainerColor = ColorField,
                        disabledContainerColor = ColorField,
                    ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row{
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = "We texted you a code to verify your phone number", fontSize = 18.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = "This code will expired 10 minutes after this message. If you don't get a message.",fontSize = 18.sp, textAlign = TextAlign.Center)
            }
        }
    }

}