package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerLowLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl11
            AppTheme.STANDARD -> R.color.cstl11
            AppTheme.BLUE -> R.color.cbl11
            AppTheme.GREEN -> R.color.cgl11
            AppTheme.RED -> R.color.crl11
            AppTheme.NOTHING -> R.color.cnol11
        }
    }
}
