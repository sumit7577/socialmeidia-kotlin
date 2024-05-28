package com.ai.socialmedia.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
fun Password(modifier: Modifier = Modifier,navController: NavController){
    var text by rememberSaveable { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    Surface(modifier=modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background){
        Column(modifier = modifier
            .fillMaxSize()
            .padding(25.dp, 15.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp))
        {
            Column(modifier = modifier.fillMaxWidth(),
                verticalArrangement =  Arrangement.spacedBy(50.dp)) {
                AuthHeader()
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(
                        text = buildAnnotatedString {
                            append("You’ll need a")
                            withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold)) {
                                append(" Password.")
                            }
                        },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                    Text(
                        text = "Make sure it’s 8 characters or more.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                }

            }

            Column(modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(30.dp)) {

                Column(verticalArrangement = Arrangement.spacedBy(5.dp)){
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Password") },
                        shape = RoundedCornerShape(18.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier  = modifier.fillMaxWidth(),// More rounded corners
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Primary,   // Custom border color when focused
                            unfocusedBorderColor = Color.Gray  // Custom border color when unfocused
                        ),
                        trailingIcon = {
                            Icon(
                                imageVector = if(showPassword) Icons.Outlined.Visibility else  Icons.Outlined.VisibilityOff,
                                contentDescription = "Password icon",
                                modifier = Modifier.clickable { showPassword = true }
                            )
                        },
                    )
                }
                Text(
                    text = buildAnnotatedString {
                        append("By signing up, you agree to the")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append("  Terms of Service ")
                        }
                        append("and")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Privacy Policy, ")
                        }
                        append("including")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Cookie Use. ")
                        }
                        append("AI may use your contact information, including your email address and phone number for purposes outlined in our Privacy Policy, like keeping your account secure and personalizing our services, including ads.")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Learn More. ")
                        }
                        append("Others will be able to find you by email or phone\n" +
                                "number, when provided, unless you choose otherwise")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" here. ")
                        }
                    },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                )

            }

            Column(modifier=modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom) {

                ElevatedButton(onClick = { navController.navigate(AuthScreen.SetProfilePicture) },
                    colors = ButtonColors(Color.Black, Color.White, Color.White, Color.Black),
                    shape = RoundedCornerShape(18.dp),
                    modifier= modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text="Sign up",
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
fun SetPasswordPreview() {
    val navController = rememberNavController()
    Password(navController = navController)
}




