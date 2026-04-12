package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EInverseSurfaceLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl7
            AppTheme.STANDARD -> R.color.cstl7
            AppTheme.BLUE -> R.color.cbl7
            AppTheme.GREEN -> R.color.cgl7
            AppTheme.RED -> R.color.crl7
            AppTheme.NOTHING -> R.color.cnol7
        }
    }
}
