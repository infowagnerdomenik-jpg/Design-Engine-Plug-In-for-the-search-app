package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSurfaceVariantDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd6
            AppTheme.STANDARD -> R.color.cstd6
            AppTheme.BLUE -> R.color.cbd6
            AppTheme.GREEN -> R.color.cgd6
            AppTheme.RED -> R.color.crd6
            AppTheme.NOTHING -> R.color.cnod6
        }
    }
}
