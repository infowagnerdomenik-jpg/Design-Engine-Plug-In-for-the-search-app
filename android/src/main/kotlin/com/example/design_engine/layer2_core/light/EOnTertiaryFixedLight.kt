package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryFixedLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl39
            AppTheme.STANDARD -> R.color.cstl39
            AppTheme.BLUE -> R.color.cbl39
            AppTheme.GREEN -> R.color.cgl39
            AppTheme.RED -> R.color.crl39
            AppTheme.NOTHING -> R.color.cnol39
        }
    }
}
