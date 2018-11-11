package com.peterdang.myprofile.core.utils

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.peterdang.myprofile.R
import java.io.IOException
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * ConfigReader: a secure way to read config since it is compiled with your app
 */
@Singleton
class ConfigReader @Inject constructor(private var context: Context) {
    companion object {
        val BASE_API_URL_KEY = "base_api_url"
        val MY_EMAIL_KEY = "my_email"
    }

    private val TAG = "Helper"

    fun getConfigValue(name: String): String? {
        val resources = context.resources

        try {
            val rawResource = resources.openRawResource(R.raw.config)
            val properties = Properties()
            properties.load(rawResource)
            return properties.getProperty(name)
        } catch (e: Resources.NotFoundException) {
            Log.e(TAG, "Unable to find the config file: " + e.message)
        } catch (e: IOException) {
            Log.e(TAG, "Failed to open config file.")
        }

        return null
    }
}