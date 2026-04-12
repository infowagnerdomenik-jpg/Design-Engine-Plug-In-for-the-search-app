package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl15
            AppTheme.STANDARD -> R.color.cstl15
            AppTheme.BLUE -> R.color.cbl15
            AppTheme.GREEN -> R.color.cgl15
            AppTheme.RED -> R.color.crl15
            AppTheme.NOTHING -> R.color.cnol15
        }
    }
}
