package com.ai.socialmedia.ui.auth

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.socialmedia.components.AuthHeader
import com.ai.socialmedia.ui.theme.Primary
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.ai.socialmedia.R
import com.ai.socialmedia.components.RoundedButton

fun Modifier.dashedBorder(
    color: Color,
    strokeWidth: Dp,
    dashLength: Dp,
    gapLength: Dp,
    cornerRadius: Dp
) = this.then(
    Modifier.drawBehind {
        val stroke = Stroke(
            width = strokeWidth.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashLength.toPx(), gapLength.toPx())
            )
        )

        val width = size.width
        val height = size.height
        val cornerRadiusPx = cornerRadius.toPx()

        drawRoundRect(
            color = color,
            topLeft = Offset.Zero,
            size = size,
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadiusPx, cornerRadiusPx),
            style = stroke
        )
    }
)
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ProfilePicture(modifier: Modifier = Modifier){
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }
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
                            append("Pick a profile")
                            withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                                append(" Picture.")
                            }
                        },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                    Text(
                        text = buildAnnotatedString {
                            append("Have a favourite selfie?")
                            withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                                append(" Uplaod ")
                            }
                            append("it now.")
                        },
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                }

            }

            Column(modifier = modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clickable { imagePickerLauncher.launch("image/*") }
                        .dashedBorder(
                            color = Color.Gray,
                            strokeWidth = 2.dp,
                            dashLength = 10.dp,
                            gapLength = 10.dp,
                            cornerRadius = 8.dp
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedImageUri != null) {
                        val painter = rememberAsyncImagePainter(selectedImageUri)
                        Image(
                            painter = painter,
                            contentDescription = "Selected Image",
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.paper_upload), // Replace with your logo resource ID
                                contentDescription = "Logo",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(40.dp)
                            )
                            Text(
                                text = buildAnnotatedString {
                                    append("Drag & Drop or")
                                    withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.SemiBold)) {
                                        append(" choose ")
                                    }
                                    append("file to upload")
                                },
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                            Text(
                                text = "Select Png, jpg or svg",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }

            Column(modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()) {
                    RoundedButton(text = "Skip Now", backgroundColor = Color.Unspecified, textColor = Color.Black)
                    RoundedButton(text = "Sign Up", backgroundColor = Color.Black, textColor = Color.White)
                }

            }

        }

    }
}