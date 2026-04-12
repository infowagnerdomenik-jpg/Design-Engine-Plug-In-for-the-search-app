package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl3
            AppTheme.STANDARD -> R.color.cstl3
            AppTheme.BLUE -> R.color.cbl3
            AppTheme.GREEN -> R.color.cgl3
            AppTheme.RED -> R.color.crl3
            AppTheme.NOTHING -> R.color.cnol3
        }
    }
}
