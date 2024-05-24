package com.ai.socialmedia.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.window.layout.DisplayFeature
import com.ai.socialmedia.ui.home.MainScreen
import com.ai.socialmedia.R
import com.ai.socialmedia.ui.auth.Auth

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SocialMediaApp(
    displayFeatures: List<DisplayFeature>,
    appState: SocialMediaAppState = rememberJetcasterAppState()
) {
    val adaptiveInfo = currentWindowAdaptiveInfo()
    if (appState.isOnline) {
        NavHost(
            navController = appState.navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                Auth()
            }
        }
    } else {
        OfflineDialog { appState.refreshOnline() }
    }
}

@Composable
fun OfflineDialog(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(R.string.connection_error_title)) },
        text = { Text(text = stringResource(R.string.connection_error_message)) },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(stringResource(R.string.retry_label))
            }
        }
    )
}