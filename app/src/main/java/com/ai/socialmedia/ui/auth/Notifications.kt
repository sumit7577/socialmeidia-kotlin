package com.ai.socialmedia.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.socialmedia.components.AuthHeader
import com.ai.socialmedia.ui.AuthScreen
import com.ai.socialmedia.ui.theme.Primary

@Composable
fun Notifications(modifier: Modifier = Modifier,navController: NavController){
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
                )
                Text(
                    text="Get the most out of AI by staying up to date with What’s happening. ",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                ElevatedButton(onClick = { navController.navigate(AuthScreen.Peoples.route) },
                    colors = ButtonColors(Color.Black, Color.White, Color.White, Color.Black),
                    shape = RoundedCornerShape(18.dp),
                    modifier= modifier
                        .height(50.dp).fillMaxWidth()
                ) {
                    Text(text="Allow Notifications",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                OutlinedButton(onClick = { navController.navigate(AuthScreen.Peoples.route) },
                    colors = ButtonColors(Color.White, Color.Black, Color.Black, Color.White),
                    shape = RoundedCornerShape(18.dp),
                    modifier= modifier
                        .height(50.dp).fillMaxWidth()
                ) {
                    Text(text="Skip for Now",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun SetNotificationSettingPreview() {
    val navController = rememberNavController()
    Notifications(navController = navController)
}