package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSurfaceVariantLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl6
            AppTheme.STANDARD -> R.color.cstl6
            AppTheme.BLUE -> R.color.cbl6
            AppTheme.GREEN -> R.color.cgl6
            AppTheme.RED -> R.color.crl6
            AppTheme.NOTHING -> R.color.cnol6
        }
    }
}
