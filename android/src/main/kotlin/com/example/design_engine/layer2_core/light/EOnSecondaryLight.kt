package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl26
            AppTheme.STANDARD -> R.color.cstl26
            AppTheme.BLUE -> R.color.cbl26
            AppTheme.GREEN -> R.color.cgl26
            AppTheme.RED -> R.color.crl26
            AppTheme.NOTHING -> R.color.cnol26
        }
    }
}
