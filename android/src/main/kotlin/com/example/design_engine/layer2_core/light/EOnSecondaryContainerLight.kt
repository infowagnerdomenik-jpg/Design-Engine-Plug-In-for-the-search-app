package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl28
            AppTheme.STANDARD -> R.color.cstl28
            AppTheme.BLUE -> R.color.cbl28
            AppTheme.GREEN -> R.color.cgl28
            AppTheme.RED -> R.color.crl28
            AppTheme.NOTHING -> R.color.cnol28
        }
    }
}
