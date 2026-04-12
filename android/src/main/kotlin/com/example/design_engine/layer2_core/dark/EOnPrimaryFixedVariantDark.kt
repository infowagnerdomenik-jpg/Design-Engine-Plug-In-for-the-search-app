package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnPrimaryFixedVariantDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd23
            AppTheme.STANDARD -> R.color.cstd23
            AppTheme.BLUE -> R.color.cbd23
            AppTheme.GREEN -> R.color.cgd23
            AppTheme.RED -> R.color.crd23
            AppTheme.NOTHING -> R.color.cnod23
        }
    }
}
