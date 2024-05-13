package uz.ictschool.bank.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.ictschool.bank.MyApp
import uz.ictschool.bank.R
import uz.ictschool.bank.navigation.Screen
import uz.ictschool.bank.utils.SharedPrefHelper

@Composable
fun Splash(navController: NavController) {
    val shared = SharedPrefHelper.getInstance(MyApp.context)
    val isFirstTime = shared.getIsFirstTime()
    val context = LocalContext.current
    LaunchedEffect("") {
        delay(3000)
        if (isFirstTime) {
            navController.navigate(Screen.Welcome.route)
        } else {
            val loggedIn = SharedPrefHelper.getInstance(context).getUserNumber() != ""
            if (loggedIn) navController.navigate(Screen.Home.route)
            navController.navigate(Screen.SignIn.route)
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
//        val baloo2 = FontFamily(Font(R.font.baloo2variablefont_wght))
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(1f)
        )
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Bank", fontSize = 45.sp, color = Color.Black)
            Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "",
                Modifier.size(50.dp)
            )
        }
    }
}