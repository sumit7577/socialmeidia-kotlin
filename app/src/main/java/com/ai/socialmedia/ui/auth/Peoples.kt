package com.ai.socialmedia.ui.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.ai.socialmedia.R
import com.ai.socialmedia.components.RoundedButton
import com.ai.socialmedia.ui.AuthScreen
import com.ai.socialmedia.ui.theme.Primary

@Composable
fun CirclesWithMargin(
    outerCircleSize: Dp,
    outerBorderColor: Color,
    borderWidth: Dp,
    dashArray: FloatArray,
    content:@Composable()(BoxScope.()->Unit)
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(outerCircleSize)
    ) {
        // Outer Circle with Dashed Border
        Canvas(modifier = Modifier.matchParentSize()) {
            drawCircle(
                color = outerBorderColor,
                radius = (size.minDimension / 2) - (borderWidth.toPx() / 2),
                center = center,
                style = Stroke(width = borderWidth.toPx(), pathEffect = PathEffect.dashPathEffect(dashArray))
            )
        }
        content()
    }
}
@Composable
fun Peoples(modifier:Modifier = Modifier,navController: NavController){
    Surface(
        modifier=modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier= modifier
            .fillMaxSize()
            .padding(25.dp, 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween) {
            Column(modifier= modifier
                .fillMaxWidth()
                .paddingFromBaseline(20.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                CirclesWithMargin(
                    outerCircleSize = 145.dp,
                    outerBorderColor = Color.Gray,
                    borderWidth = 2.dp,
                    dashArray = floatArrayOf(10f, 10f)
                ){
                    CirclesWithMargin(
                        outerCircleSize = 125.dp,
                        outerBorderColor = Color.Gray,
                        borderWidth = 2.dp,
                        dashArray = floatArrayOf(10f, 10f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .padding(2.dp)
                                .clip(CircleShape)
                                .border(
                                    width = 2.dp,
                                    color = Color.Black,
                                    shape = CircleShape
                                )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.follower_icon_background),
                                contentDescription = "Sync Contact",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize()
                            )
                        }
                    }
                }
            }
            
            Column(modifier= modifier
                .fillMaxWidth()
                .weight(1f, fill = true),
                verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = buildAnnotatedString {
                        append("See who’s on")
                        withStyle(style = SpanStyle(color= Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Ai ")
                        }
                    },
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                    Text(text = "Syncing your contact is one way to find people to follow and build your timeline.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)){
                        Image(painter = painterResource(id = R.drawable.bell_plus), contentDescription = null )
                        Text(
                            text="You decide who to follow",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)){
                        Image(painter = painterResource(id = R.drawable.mail_02), contentDescription = null )
                        Text(
                            text="Get notified when someone you know joins Ai ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)){
                        Image(painter = painterResource(id = R.drawable.send_01), contentDescription = null )
                        Text(
                            text="Turn off syncing at any time",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal)
                    }
                }
                
                Column {
                    Text(text = buildAnnotatedString {
                        append("We will periodically upload your address book contacts to help you connect with them and personalize content for you and others. You can turn off syncing and remove uploaded contacts in your settings")
                        withStyle(style = SpanStyle(color= Primary, fontWeight = FontWeight.SemiBold)) {
                            append(" Learn more ")
                        }
                    },
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }

            Column(modifier=modifier.fillMaxWidth()) {
                ElevatedButton(onClick = { navController.navigate(AuthScreen.FollowSuggestions.route) },
                    colors = ButtonColors(Color.Black, Color.White, Color.White, Color.Black),
                    shape = RoundedCornerShape(18.dp),
                    modifier= modifier
                        .height(50.dp).fillMaxWidth()
                ) {
                    Text(text="Next",
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
fun SetPeoplePreview() {
    val navController = rememberNavController()
    Peoples(navController = navController)
}