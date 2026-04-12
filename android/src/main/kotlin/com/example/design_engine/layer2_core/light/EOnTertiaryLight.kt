package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl34
            AppTheme.STANDARD -> R.color.cstl34
            AppTheme.BLUE -> R.color.cbl34
            AppTheme.GREEN -> R.color.cgl34
            AppTheme.RED -> R.color.crl34
            AppTheme.NOTHING -> R.color.cnol34
        }
    }
}
