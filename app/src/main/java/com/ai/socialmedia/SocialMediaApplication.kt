package com.ai.socialmedia


import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * Application which sets up our dependency [Graph] with a context.
 */
@HiltAndroidApp
class SocialMediaApplication : Application() {

}