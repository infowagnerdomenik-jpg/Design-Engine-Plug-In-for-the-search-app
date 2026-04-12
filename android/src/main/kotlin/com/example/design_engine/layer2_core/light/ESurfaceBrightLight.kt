package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceBrightLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl9
            AppTheme.STANDARD -> R.color.cstl9
            AppTheme.BLUE -> R.color.cbl9
            AppTheme.GREEN -> R.color.cgl9
            AppTheme.RED -> R.color.crl9
            AppTheme.NOTHING -> R.color.cnol9
        }
    }
}
