package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryFixedLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl31
            AppTheme.STANDARD -> R.color.cstl31
            AppTheme.BLUE -> R.color.cbl31
            AppTheme.GREEN -> R.color.cgl31
            AppTheme.RED -> R.color.crl31
            AppTheme.NOTHING -> R.color.cnol31
        }
    }
}
