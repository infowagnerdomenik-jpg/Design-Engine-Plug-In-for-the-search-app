package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd25
            AppTheme.STANDARD -> R.color.cstd25
            AppTheme.BLUE -> R.color.cbd25
            AppTheme.GREEN -> R.color.cgd25
            AppTheme.RED -> R.color.crd25
            AppTheme.NOTHING -> R.color.cnod25
        }
    }
}
