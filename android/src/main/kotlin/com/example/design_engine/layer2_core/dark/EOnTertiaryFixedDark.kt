package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryFixedDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd39
            AppTheme.STANDARD -> R.color.cstd39
            AppTheme.BLUE -> R.color.cbd39
            AppTheme.GREEN -> R.color.cgd39
            AppTheme.RED -> R.color.crd39
            AppTheme.NOTHING -> R.color.cnod39
        }
    }
}
