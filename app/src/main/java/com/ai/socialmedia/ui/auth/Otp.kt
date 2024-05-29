package com.ai.socialmedia.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.socialmedia.components.AuthHeader
import com.ai.socialmedia.ui.AuthScreen
import com.ai.socialmedia.ui.theme.Primary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Otp(modifier: Modifier = Modifier,navController: NavController){
    var text by rememberSaveable { mutableStateOf("") }
    Surface(modifier=modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background){
        Column(modifier = modifier
            .fillMaxSize()
            .padding(25.dp, 15.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp))
        {
            Column(modifier = modifier.fillMaxWidth(),
                verticalArrangement =  Arrangement.spacedBy(30.dp)) {
                AuthHeader()
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = buildAnnotatedString {
                            append("We sent you a")
                            withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold)) {
                                append(" Code.")
                            }
                        },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                    )
                    Text(
                        text = "Enter it below to verify +91 99999 99999",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                }

            }

            Column(modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)) {

                Column(verticalArrangement = Arrangement.spacedBy(5.dp)){
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Waiting for SMS to arrive...") },
                        shape = RoundedCornerShape(18.dp),
                        modifier  = modifier.fillMaxWidth(),// More rounded corners
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Primary,   // Custom border color when focused
                            unfocusedBorderColor = Color.Gray  // Custom border color when unfocused
                        ),
                    )
                    Text(
                        text = "0/6",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                        textAlign = TextAlign.Right,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(10.dp, 0.dp)
                    )
                }
                Text(
                    text = "Didn’t receive SMS?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Primary,
                )

            }

            Column(modifier=modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom) {
                ElevatedButton(onClick = { navController.navigate(AuthScreen.SetPassword.route) },
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

@Preview(showBackground = true)
@Composable
fun OtpPreview() {
    val navController = rememberNavController()
    Otp(navController = navController)
}




