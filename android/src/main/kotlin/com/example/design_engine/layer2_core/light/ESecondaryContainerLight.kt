package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl27
            AppTheme.STANDARD -> R.color.cstl27
            AppTheme.BLUE -> R.color.cbl27
            AppTheme.GREEN -> R.color.cgl27
            AppTheme.RED -> R.color.crl27
            AppTheme.NOTHING -> R.color.cnol27
        }
    }
}
