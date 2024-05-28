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
import com.ai.socialmedia.R
import com.ai.socialmedia.ui.auth.Auth
import com.ai.socialmedia.ui.auth.LanguageSelect
import com.ai.socialmedia.ui.auth.Notifications
import com.ai.socialmedia.ui.auth.Otp
import com.ai.socialmedia.ui.auth.Password
import com.ai.socialmedia.ui.auth.Peoples
import com.ai.socialmedia.ui.auth.ProfilePicture
import com.ai.socialmedia.ui.auth.SignUp
import com.ai.socialmedia.ui.auth.SuggestedFollows

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SocialMediaApp(
    displayFeatures: List<DisplayFeature>,
    appState: SocialMediaAppState = rememberSocialMediaAppState()
) {
    val adaptiveInfo = currentWindowAdaptiveInfo()
    if (appState.isOnline) {
        val authNavController = appState.navController
        NavHost(
            navController = authNavController,
            startDestination = AuthScreen.Auth
        ) {
            composable<AuthScreen.Auth> {
                Auth(navController = authNavController)
            }
            composable<AuthScreen.Signup> {
                SignUp(navController = authNavController)
            }
            composable<AuthScreen.OtpVerify> {
                Otp(navController = authNavController)
            }
            composable<AuthScreen.SetPassword> {
                Password(navController = authNavController)
            }
            composable<AuthScreen.SetProfilePicture> {
                ProfilePicture(navController = authNavController)
            }
            composable<AuthScreen.NotificationSetting> {
                Notifications(navController = authNavController)
            }
            composable<AuthScreen.Peoples> {
                Peoples(navController = authNavController)
            }
            composable<AuthScreen.FollowSuggestions> {
                SuggestedFollows(navController = authNavController)
            }
            composable<AuthScreen.SetLanguage> {
                LanguageSelect(navController = authNavController)
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