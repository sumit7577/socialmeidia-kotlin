package com.ai.socialmedia.ui.auth


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ai.socialmedia.R
import com.ai.socialmedia.ui.theme.*
import androidx.navigation.compose.rememberNavController
import com.ai.socialmedia.ui.AuthScreen

@Composable
fun Auth(modifier:Modifier = Modifier,navController:NavController) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier= Modifier
            .fillMaxSize()
            .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo), // Replace with your logo resource ID
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(50.dp)
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = buildAnnotatedString {
                        append("Explore The")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold)) {
                            append(" Latest Events ")
                        }
                        append("Unfolding Across")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold)) {
                            append(" The Globe. ")
                        }
                    },
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier.padding(end=50.dp),
                    lineHeight = 50.sp
                )
            }

            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                OutlinedButton(onClick = { navController.navigate(AuthScreen.Signup.route) },
                    colors = ButtonColors(Color.White, Color.Black, Color.White, Color.Black),
                    shape = RoundedCornerShape(18.dp),
                    modifier= modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text="Continue with Google",
                        fontSize = 16.sp,
                        color= Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                ElevatedButton(onClick = { navController.navigate(AuthScreen.Signup.route) },
                    colors = ButtonColors(Color.Black, Color.White, Color.White, Color.Black),
                    shape = RoundedCornerShape(18.dp),
                    modifier= modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text="Create New Account",
                        fontSize = 16.sp,
                        color= Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = buildAnnotatedString {
                        append("By signing up, you agree to our")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append("  Terms, privacy policy ")
                        }
                        append(", and")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Cookie Use. ")
                        }
                    },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = buildAnnotatedString {
                        append("Have an account already?")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Log in ")
                        }
                    },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun AuthPreview() {
    val navController = rememberNavController()
    Auth(navController = navController)
}
