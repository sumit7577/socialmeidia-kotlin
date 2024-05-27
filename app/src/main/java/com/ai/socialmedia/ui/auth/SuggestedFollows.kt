package com.ai.socialmedia.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.socialmedia.components.RoundedButton
import com.ai.socialmedia.ui.theme.Primary
import com.ai.socialmedia.R


@Composable
fun ListItem(modifier:Modifier=Modifier,item: String) {
    Row(modifier=Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = modifier.padding(0.dp,0.dp,20.dp,0.dp).clip(CircleShape)
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = CircleShape
            ).height(60.dp).width(60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.follower_icon_background),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                )
        }
        Column {
            Text(text=item,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
            Text(text=item,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center)
        }
        Column(modifier= modifier.weight(1f,fill=true),
            horizontalAlignment = Alignment.End) {
            ElevatedButton(onClick = { /*TODO*/ },
                colors = ButtonColors(Color.Black, Color.White, Color.White, Color.Black),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text="Follow")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuggestedFollows(modifier:Modifier = Modifier) {
    val itemsList = List(100) { "Item #$it" }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val lazyColumnHeight = screenHeight * 0.5f
    Surface(modifier=modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column(modifier= modifier
            .fillMaxSize()
            .padding(25.dp, 20.dp),
            verticalArrangement = Arrangement.SpaceBetween)
        {
            Column(modifier=modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = buildAnnotatedString {
                    append("Suggested")
                    withStyle(style = SpanStyle(color= Primary, fontWeight = FontWeight.SemiBold)) {
                        append(" Follows ")
                    }
                },
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )

                Text(text="You’ll see posts from people you follow in your home timeline.",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal)
            }

            Column(modifier=modifier.weight(1f,fill=true).padding(0.dp,20.dp,0.dp,40.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)){
                Text(text="People you may know",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    color=Primary
                )
                LazyColumn(
                    modifier = Modifier
                        .weight(1f, fill = true),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(itemsList) { item ->
                        ListItem(modifier,item)
                    }
                }
            }

            Column(modifier=modifier.fillMaxWidth()) {
                RoundedButton(text = "Next", backgroundColor = Color.Black, textColor = Color.White)

            }

        }

    }
}