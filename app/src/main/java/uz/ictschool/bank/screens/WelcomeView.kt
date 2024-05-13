package uz.ictschool.bank.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.ictschool.bank.R
import uz.ictschool.bank.models.PagerItem
import uz.ictschool.bank.navigation.Screen
import uz.ictschool.bank.ui.theme.purple
import uz.ictschool.bank.utils.SharedPrefHelper

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Welcome(navController: NavController) {
    val buttonColor = Color(0xFF0097d8)
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    val context = LocalContext.current
    val list = listOf(
        PagerItem(R.drawable.img2, "Trustworthy", ""),
        PagerItem(R.drawable.comission, "No commission", ""),
        PagerItem(R.drawable.fast, "Fast", "")
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        Text(text = "Welcome to the", fontSize = 32.sp, color = buttonColor)
        Row(
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Bank", fontSize = 35.sp, color = Color.Black)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                Modifier.size(33.dp)
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        HorizontalPager(state = pagerState) { index ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(350.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (index == 1) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    )
                    Image(
                        painter = painterResource(id = list[index].img),
                        contentDescription = "img",
                        Modifier.size(250.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                } else {
                    Image(
                        painter = painterResource(id = list[index].img),
                        contentDescription = "img",
                        Modifier.size(300.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }

                Text(
                    text = list[index].text,

                    color = Color.Black,
                    fontSize = 26.sp,
                    modifier = Modifier.padding()
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()

                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) purple else buttonColor
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(13.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(35.dp))
        Button(
            onClick = {
                SharedPrefHelper.getInstance(context).setIsFirstTime(false)
                navController.navigate(Screen.SignIn.route) {
                    popUpTo(navController.graph.id)
                }
            },
            modifier = Modifier.width(230.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = "Sign in", color = Color.Black, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}