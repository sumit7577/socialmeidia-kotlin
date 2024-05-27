package com.ai.socialmedia.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.socialmedia.components.AuthHeader
import com.ai.socialmedia.components.RoundedButton
import com.ai.socialmedia.ui.theme.Primary

@Preview(showBackground = true)
@Composable
fun Notifications(modifier: Modifier = Modifier){
    Surface(
        modifier=modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier.fillMaxSize().padding(25.dp, 15.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                AuthHeader()
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(
                    text = buildAnnotatedString {
                        append("Turn on")
                        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Notifications ")
                        }
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                )
                Text(
                    text="Get the most out of AI by staying up to date with What’s happening. ",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }

            Column {
                RoundedButton(text = "Allow Notifications", backgroundColor = Color.Black, textColor =Color.White)
                RoundedButton(text = "Skip for Now", backgroundColor = Color.White, textColor =Color.Black)
            }

        }
    }

}