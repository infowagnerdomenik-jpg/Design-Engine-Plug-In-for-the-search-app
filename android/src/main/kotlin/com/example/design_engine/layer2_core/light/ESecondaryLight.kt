package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl25
            AppTheme.STANDARD -> R.color.cstl25
            AppTheme.BLUE -> R.color.cbl25
            AppTheme.GREEN -> R.color.cgl25
            AppTheme.RED -> R.color.crl25
            AppTheme.NOTHING -> R.color.cnol25
        }
    }
}
