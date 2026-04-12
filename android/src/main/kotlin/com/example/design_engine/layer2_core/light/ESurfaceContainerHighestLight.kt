package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerHighestLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl14
            AppTheme.STANDARD -> R.color.cstl14
            AppTheme.BLUE -> R.color.cbl14
            AppTheme.GREEN -> R.color.cgl14
            AppTheme.RED -> R.color.crl14
            AppTheme.NOTHING -> R.color.cnol14
        }
    }
}
