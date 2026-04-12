package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryFixedVariantLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl40
            AppTheme.STANDARD -> R.color.cstl40
            AppTheme.BLUE -> R.color.cbl40
            AppTheme.GREEN -> R.color.cgl40
            AppTheme.RED -> R.color.crl40
            AppTheme.NOTHING -> R.color.cnol40
        }
    }
}
