package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryFixedVariantDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd32
            AppTheme.STANDARD -> R.color.cstd32
            AppTheme.BLUE -> R.color.cbd32
            AppTheme.GREEN -> R.color.cgd32
            AppTheme.RED -> R.color.crd32
            AppTheme.NOTHING -> R.color.cnod32
        }
    }
}
