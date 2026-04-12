package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerHighLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl12
            AppTheme.STANDARD -> R.color.cstl12
            AppTheme.BLUE -> R.color.cbl12
            AppTheme.GREEN -> R.color.cgl12
            AppTheme.RED -> R.color.crl12
            AppTheme.NOTHING -> R.color.cnol12
        }
    }
}
