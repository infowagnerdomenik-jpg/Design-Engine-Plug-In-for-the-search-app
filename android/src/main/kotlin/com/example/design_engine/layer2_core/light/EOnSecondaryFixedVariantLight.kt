package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryFixedVariantLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl32
            AppTheme.STANDARD -> R.color.cstl32
            AppTheme.BLUE -> R.color.cbl32
            AppTheme.GREEN -> R.color.cgl32
            AppTheme.RED -> R.color.crl32
            AppTheme.NOTHING -> R.color.cnol32
        }
    }
}
