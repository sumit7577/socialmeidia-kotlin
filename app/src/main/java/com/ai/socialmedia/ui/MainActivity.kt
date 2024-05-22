package com.ai.socialmedia.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ai.socialmedia.ui.theme.SocialMediaTheme
import com.google.accompanist.adaptive.calculateDisplayFeatures
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge()

        setContent{
            val displayFeature = calculateDisplayFeatures(this)
            SocialMediaTheme {
                SocialMediaApp(displayFeature)
            }
        }
    }
}