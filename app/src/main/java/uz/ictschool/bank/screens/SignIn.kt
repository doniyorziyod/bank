package uz.ictschool.bank.screens

import android.media.midi.MidiOutputPort
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.ictschool.bank.R
import uz.ictschool.bank.ui.theme.purple

@Preview
@Composable
fun PreviewSignIn() {
    SignIn(navController = rememberNavController())
}

@Composable
fun SignIn(navController: NavController) {
    val phonenumber = remember { mutableStateOf("") }
    Box {

    }
    Column(
        Modifier
            .fillMaxSize()
            .background(purple)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp, top = 16.dp, bottom = 16.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "",
                    Modifier.size(22.dp),
                    tint = Color.White
                )

            }

            Text(
                text = "Sign in",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Card(
            modifier = Modifier
                .fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ) {
            Spacer(modifier = Modifier.height(6.dp))
            Row {
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Welcome to us",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = purple
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row {
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Hello there, sign in to continue", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
          Image(painter = painterResource(id = R.drawable.phone), contentDescription = "phone",
              modifier = Modifier
                  .height(260.dp)
                  .width(260.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))
          Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
              Row {
                  TextField(
                      value = phonenumber.value,
                      onValueChange = { phonenumber.value = it },
                      placeholder = { Text(text = "Phone number") },
                      textStyle =
                      androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
                      singleLine = true,
                      shape = RoundedCornerShape(24.dp)
                  )
              }
          }
            Spacer(modifier = Modifier.height(240.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(purple), modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)) {
                    Text(text = "Continue", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 6.dp, bottom = 6.dp))
                }
            }

        }
    }
}