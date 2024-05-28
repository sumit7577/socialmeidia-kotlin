package com.ai.socialmedia.ui.auth

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ai.socialmedia.components.AuthHeader
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.socialmedia.components.RoundedButton
import com.ai.socialmedia.ui.AuthScreen
import com.ai.socialmedia.ui.theme.*
import com.ozcanalasalvar.datepicker.compose.datepicker.WheelDatePicker
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(modifier:Modifier = Modifier,navController: NavController){
    var text by rememberSaveable { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    var isDatePickerVisible by remember { mutableStateOf(false) }
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column(modifier= modifier
            .fillMaxSize()
            .padding(25.dp, 15.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Column(modifier= modifier.fillMaxWidth()) {
                AuthHeader()
            }

            Column(modifier = modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Text(
                    text = buildAnnotatedString {
                        append("Create Your")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold)) {
                            append(" Account")
                        }
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Name") },
                    shape = RoundedCornerShape(18.dp),
                    modifier  = modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Primary,   // Custom border color when focused
                        unfocusedBorderColor = Color.Gray  // Custom border color when unfocused
                    ),
                )

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Phone") },
                    shape = RoundedCornerShape(18.dp),
                    modifier  = modifier.fillMaxWidth(),// More rounded corners
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Primary,   // Custom border color when focused
                        unfocusedBorderColor = Color.Gray  // Custom border color when unfocused
                    ),
                )

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Date of Birth") },
                    shape = RoundedCornerShape(18.dp),
                    modifier  = modifier.fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.CalendarToday,
                            contentDescription = "Calendar Icon",
                            modifier = Modifier.clickable { isDatePickerVisible = true }
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Primary,   // Custom border color when focused
                        unfocusedBorderColor = Color.Gray  // Custom border color when unfocused
                    ),
                )
            }

            Column(modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom) {
                if(isDatePickerVisible){
                    WheelDatePicker(offset = 3, textSize = 20, onDateChanged = { day, month, year, date ->
                        Log.d("SelectedDate", "$day / $month / $year")
                    })
                }
                ElevatedButton(onClick = { navController.navigate(AuthScreen.OtpVerify) },
                    colors = ButtonColors(Color.Black, Color.White, Color.White, Color.Black),
                    shape = RoundedCornerShape(18.dp),
                    modifier= modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text="Next",
                        fontSize = 16.sp,
                        color= Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    val navController = rememberNavController()
    SignUp(navController = navController)
}