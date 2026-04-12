package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryFixedDimDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd30
            AppTheme.STANDARD -> R.color.cstd30
            AppTheme.BLUE -> R.color.cbd30
            AppTheme.GREEN -> R.color.cgd30
            AppTheme.RED -> R.color.crd30
            AppTheme.NOTHING -> R.color.cnod30
        }
    }
}
