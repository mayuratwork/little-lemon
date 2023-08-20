package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.littlelemon.ui.theme.Gray
import com.example.littlelemon.ui.theme.Yellow

@Composable
fun OnBoarding(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        val context = LocalContext.current
        var firstName by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var lastName by remember { mutableStateOf(TextFieldValue("")) }
        val sharedPref = context.getSharedPreferences(
            stringResource(R.string.little_lemon_sp), Context.MODE_PRIVATE)
        val focusManager = LocalFocusManager.current
        val focusFirstName = remember { FocusRequester() }
        val focusLastName = remember { FocusRequester() }
        val focusEmail = remember { FocusRequester() }

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
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 24.dp, bottom = 24.dp),
                    color = Color.White)
            }

            Text(
                modifier = Modifier.padding(18.dp),
                color = Color.Black,
                fontSize = 24.sp,
                text = "Personal Information")


            TextField(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                value = firstName,
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Gray,
                    textColor = Gray,
                    unfocusedBorderColor = Gray),

                onValueChange = {
                    firstName = it
                },
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { focusLastName.requestFocus() }
                ),
                label = { Text(text = "First Name", color = Gray, fontSize = 16.sp) })

            TextField(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth()
                    .focusRequester(focusLastName),
                value = lastName,
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Gray,
                    textColor = Gray,
                    unfocusedBorderColor = Gray),
                onValueChange = {
                    lastName = it
                },
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { focusEmail.requestFocus() }
                ),
                label = { Text(text = "Last Name", color = Gray, fontSize = 16.sp) })

            TextField(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth()
                    .focusRequester(focusEmail),
                value = email,
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Gray,
                    textColor = Gray,
                    unfocusedBorderColor = Gray),
                onValueChange = {
                    email = it
                },
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                label = { Text(text = "Email", color = Gray, fontSize = 16.sp) })

        }

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Yellow,
                contentColor = Gray),
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            onClick = {
                if (firstName.text.isBlank() || lastName.text.isBlank() ||
                    email.text.isBlank()) {
                    Toast.makeText(context,
                        "Registration unsuccessful. Please enter all data.",
                        Toast.LENGTH_LONG).show()

                } else {
                    sharedPref.edit().putString("firstName", firstName.text).apply()
                    sharedPref.edit().putString("lastName", lastName.text).apply()
                    sharedPref.edit().putString("email", email.text).apply()

                    Toast.makeText(context, "Registration successful!",
                        Toast.LENGTH_LONG).show()

                    navController.navigate(Home.route) {
                        popUpTo(OnBoarding.route) { inclusive = true }
                    }
                }
            }
        ) {
            Text(text = "Register")
        }
    }
<<<<<<< HEAD
}

private fun isRegistrationValid(): Boolean {
    return true
}

/*override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        LittleLemonTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
            ) {
                OnBoardingInit()
            }
        }
    }
}*/

=======
}
>>>>>>> 276736469eb81f2cbb8bf158c5913074e151e15f
