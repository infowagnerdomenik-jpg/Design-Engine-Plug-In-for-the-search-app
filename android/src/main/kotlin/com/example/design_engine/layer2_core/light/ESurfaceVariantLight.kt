package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceVariantLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl5
            AppTheme.STANDARD -> R.color.cstl5
            AppTheme.BLUE -> R.color.cbl5
            AppTheme.GREEN -> R.color.cgl5
            AppTheme.RED -> R.color.crl5
            AppTheme.NOTHING -> R.color.cnol5
        }
    }
}
