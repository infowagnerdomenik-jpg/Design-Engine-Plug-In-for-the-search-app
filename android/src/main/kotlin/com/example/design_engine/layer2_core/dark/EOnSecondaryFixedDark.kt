package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryFixedDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd31
            AppTheme.STANDARD -> R.color.cstd31
            AppTheme.BLUE -> R.color.cbd31
            AppTheme.GREEN -> R.color.cgd31
            AppTheme.RED -> R.color.crd31
            AppTheme.NOTHING -> R.color.cnod31
        }
    }
}
