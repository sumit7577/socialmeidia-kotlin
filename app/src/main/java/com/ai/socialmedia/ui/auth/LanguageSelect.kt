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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.ai.socialmedia.R
import com.ai.socialmedia.ui.theme.Primary


@Composable
fun ListLanguage(modifier:Modifier=Modifier,language: String, isSelected: Boolean, onSelect: () -> Unit) {
    Row(modifier=Modifier.fillMaxWidth().border(
        width = 2.dp,
        color = if(isSelected) Color.Black else Color.LightGray,
        shape= RoundedCornerShape(8.dp)).
    graphicsLayer {
        shadowElevation = if(isSelected) 4.dp.toPx() else 0.dp.toPx()
        shape = RoundedCornerShape(8.dp)}.
    background(if(isSelected) Color.Black else Color.White).
    padding(14.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painter = painterResource(id = R.drawable.mail_02), contentDescription = null,
            colorFilter = if(isSelected)ColorFilter.tint(Color.White) else null
        )
        Text(
            text=language,
            color = if(isSelected) Color.White else Color.Black,
            fontSize = 18.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelect(modifier:Modifier=Modifier,navController: NavController) {
    var text by rememberSaveable { mutableStateOf("") }
    val languages = listOf("Gujarati - ગુજરાતી", "Hindi - हिंदी", "Tamil - ತಮಿಳು", "Marathi - मराठी","Bangali - বাংলায়")
    var selectedLanguage by remember { mutableStateOf(languages[0]) }
    Surface(
        modifier=modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(25.dp, 25.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = buildAnnotatedString {
                    append("Which languages do you")
                    withStyle(style = SpanStyle(color= Primary, fontWeight = FontWeight.SemiBold)) {
                        append(" Speak? ")
                    }
                },
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    color= Color.Black
                )

                Text(text="You’ll be able to see posts, people, and trends in any languages you choose.",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal)
            }
            Column(modifier= modifier
                .weight(1f, fill = true)
                .padding(0.dp, 30.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Search Your language") },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Calendar Icon",
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier  = modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.LightGray,   // Custom border color when focused
                        unfocusedBorderColor = Color.LightGray  // Custom border color when unfocused
                    ),
                )

                LazyColumn(
                    modifier = Modifier
                        .weight(1f, fill = true),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(languages) { item ->
                        ListLanguage(modifier,language = item,
                            isSelected = item == selectedLanguage,
                            onSelect = { selectedLanguage = item })
                    }
                }
            }
            Column {
                ElevatedButton(onClick = { /*TODO*/ },
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
fun SetLanguageSelect() {
    val navController = rememberNavController()
    LanguageSelect(navController = navController)
}