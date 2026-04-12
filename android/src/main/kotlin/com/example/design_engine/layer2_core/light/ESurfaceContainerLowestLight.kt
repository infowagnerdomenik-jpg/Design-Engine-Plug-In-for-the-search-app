package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerLowestLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl13
            AppTheme.STANDARD -> R.color.cstl13
            AppTheme.BLUE -> R.color.cbl13
            AppTheme.GREEN -> R.color.cgl13
            AppTheme.RED -> R.color.crl13
            AppTheme.NOTHING -> R.color.cnol13
        }
    }
}
