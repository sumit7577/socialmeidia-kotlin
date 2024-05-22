package com.ai.socialmedia.ui.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.ai.socialmedia.components.RoundedButton
import com.example.socialmedia.R
import com.ai.socialmedia.ui.theme.*


@Preview(showBackground = true)
@Composable
fun Auth(modifier:Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier= Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your logo resource ID
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(64.dp)
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

                RoundedButton(text = "Continue With Google", backgroundColor = Color.White, textColor = Color.Black)
                Spacer(modifier = Modifier.height(12.dp))
                RoundedButton(text = "Create New Account", backgroundColor = Color.Black, textColor = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
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
