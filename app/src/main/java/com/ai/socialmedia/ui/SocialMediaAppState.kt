package com.ai.socialmedia.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

sealed class AuthScreen() {
    @Serializable
    object Auth

    @Serializable
    object Signup

    @Serializable
    object OtpVerify
    @Serializable
    object  SetPassword

    @Serializable
    object SetProfilePicture

    @Serializable
    object SetUsername

    @Serializable
    object NotificationSetting

    @Serializable
    object Peoples

    @Serializable
    object FollowSuggestions

    @Serializable
    object SetLanguage
}

@Composable
fun rememberSocialMediaAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
) = remember(navController, context) {
    SocialMediaAppState(navController, context)
}

class SocialMediaAppState(
    val navController: NavHostController,
    private val context: Context

){

    var isOnline by mutableStateOf(checkIfOnline())
        private set

    fun refreshOnline() {
        isOnline = checkIfOnline()
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    @Suppress("DEPRECATION")
    private fun checkIfOnline(): Boolean {
        val cm = getSystemService(context, ConnectivityManager::class.java)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities = cm?.getNetworkCapabilities(cm.activeNetwork) ?: return false
            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            cm?.activeNetworkInfo?.isConnectedOrConnecting == true
        }
    }

}