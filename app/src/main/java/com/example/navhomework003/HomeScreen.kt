package com.example.navhomework003

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navcont: NavHostController) {
    var username: String by remember { mutableStateOf("") }
    var password : String by remember { mutableStateOf("") }
    var bdate:String by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.ico_tvu)
            , contentDescription ="Logo Image"
        )
        TextField(
            value = username,
            onValueChange = {username=it},
            label = { Text(text = "Username") },
        )
        TextField(
            value = bdate,
            onValueChange = {bdate=it},
            label = { Text(text = "Birthday year") },
        )
        TextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text = "Password") },
        )
        val context1= LocalContext.current
        Button(onClick = {
            if (username=="tvu" && password=="111111"){
                navcont.navigate("Second/$username/$bdate")
            }else{
                Toast.makeText(context1,"Wrong!",Toast.LENGTH_SHORT).show()
            }
        }, colors = ButtonDefaults.buttonColors(Color(0xFF495E57))) {
            Text(text = "Login")
        }
    }
}