package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryFixedVariantDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd40
            AppTheme.STANDARD -> R.color.cstd40
            AppTheme.BLUE -> R.color.cbd40
            AppTheme.GREEN -> R.color.cgd40
            AppTheme.RED -> R.color.crd40
            AppTheme.NOTHING -> R.color.cnod40
        }
    }
}
