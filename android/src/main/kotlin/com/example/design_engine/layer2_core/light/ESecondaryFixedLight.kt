package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryFixedLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl29
            AppTheme.STANDARD -> R.color.cstl29
            AppTheme.BLUE -> R.color.cbl29
            AppTheme.GREEN -> R.color.cgl29
            AppTheme.RED -> R.color.crl29
            AppTheme.NOTHING -> R.color.cnol29
        }
    }
}
