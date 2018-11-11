package com.peterdang.curvebottomnavigationview

import android.content.Context
import android.util.DisplayMetrics


object SizeConvertor {
    fun convertDpToPixel(dp: Float, context: Context): Float {
        val resources = context.getResources()
        val metrics = resources.getDisplayMetrics()
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}