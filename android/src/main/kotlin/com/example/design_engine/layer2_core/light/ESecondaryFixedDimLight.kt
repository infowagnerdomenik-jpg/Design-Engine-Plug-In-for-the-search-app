package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryFixedDimLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl30
            AppTheme.STANDARD -> R.color.cstl30
            AppTheme.BLUE -> R.color.cbl30
            AppTheme.GREEN -> R.color.cgl30
            AppTheme.RED -> R.color.crl30
            AppTheme.NOTHING -> R.color.cnol30
        }
    }
}
