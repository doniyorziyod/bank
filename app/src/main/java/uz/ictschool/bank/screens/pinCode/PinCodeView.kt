package uz.ictschool.bank.screens.pinCode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.ictschool.bank.ui.theme.myBlue

val numbers = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

@Composable
fun PinCodeView(
    //navController: NavController
){

    Box(modifier = Modifier.fillMaxSize().padding(5.dp)){
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            verticalItemSpacing = 16.dp,
            ) {

            items(numbers){number->

                numberItem(number = number)
            }

        }
    }


    
}

@Composable
private fun numberItem(number: String){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(myBlue)
        .padding(
            vertical = 10.dp,
            ///horizontal = 30.dp
            ).clip(CircleShape)
    ) {
        Text(text = number,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun codeTest(){
    PinCodeView()
}