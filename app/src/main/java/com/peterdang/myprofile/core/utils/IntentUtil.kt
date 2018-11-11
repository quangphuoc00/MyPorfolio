package com.peterdang.myprofile.core.utils

import android.content.Intent
import android.net.Uri
import javax.inject.Inject
import androidx.core.content.ContextCompat.startActivity
import com.peterdang.myprofile.MyApplication


class IntentUtil
@Inject constructor(private val configReader: ConfigReader,
                    private val appContext: MyApplication) {
    fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:developer@example.com" +
                configReader.getConfigValue(ConfigReader.MY_EMAIL_KEY))
        appContext.startActivity(Intent.createChooser(emailIntent, "Send email..."))
    }
}