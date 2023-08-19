package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.littlelemon.ui.theme.AlmostBlack
import com.example.littlelemon.ui.theme.Gray
import com.example.littlelemon.ui.theme.Yellow


@Composable
@Preview
fun Profile(navController: NavController? = null) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences(
        stringResource(R.string.little_lemon_sp), Context.MODE_PRIVATE)
    var firstName by remember {
        mutableStateOf(TextFieldValue(sharedPref.getString("firstName", "")?.trim().toString()))
    }
    var lastName by remember {
        mutableStateOf(TextFieldValue(sharedPref.getString("lastName", "")?.trim().toString()))
    }
    var email by remember {
        mutableStateOf(TextFieldValue(sharedPref.getString("email", "")?.trim().toString()))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column() {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.padding(start = 100.dp,
                    end = 100.dp, top = 18.dp, bottom = 18.dp)
            )

            Box(Modifier
                .background(Gray)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text(
                    text = "Lets get to know you",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 24.dp, bottom = 24.dp),
                    color = Color.White)
            }

            Text(
                modifier = Modifier.padding(18.dp),
                color = Color.Black,
                fontSize = 20.sp,
                text = "Personal Information")

            TextField(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                value = firstName,
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Gray,
                    textColor = Gray,
                    unfocusedBorderColor = Gray),

                onValueChange = {
                    firstName = it
                },
                label = { Text(text = "First Name", color = Gray, fontSize = 16.sp) })

            TextField(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                value = lastName,
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Gray,
                    textColor = Gray,
                    unfocusedBorderColor = Gray),
                onValueChange = {
                    lastName = it
                },
                label = { Text(text = "Last Name", color = Gray, fontSize = 16.sp) })

            TextField(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                value = email,
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Gray,
                    textColor = Gray,
                    unfocusedBorderColor = Gray),
                onValueChange = {
                    email = it
                },
                label = { Text(text = "Email", color = Gray, fontSize = 16.sp) })

        }

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Yellow,
                contentColor = AlmostBlack),
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            onClick = {
                sharedPref.edit().clear().apply()
                navController?.navigate(OnBoarding.route) {
                    popUpTo(Home.route) { inclusive = true }
                }
            }
        ) {
            Text(text = "Log out",
                fontSize = 18.sp)
        }
    }
}