package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnPrimaryFixedLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl22
            AppTheme.STANDARD -> R.color.cstl22
            AppTheme.BLUE -> R.color.cbl22
            AppTheme.GREEN -> R.color.cgl22
            AppTheme.RED -> R.color.crl22
            AppTheme.NOTHING -> R.color.cnol22
        }
    }
}
