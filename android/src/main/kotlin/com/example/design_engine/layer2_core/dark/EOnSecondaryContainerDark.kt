package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryContainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd28
            AppTheme.STANDARD -> R.color.cstd28
            AppTheme.BLUE -> R.color.cbd28
            AppTheme.GREEN -> R.color.cgd28
            AppTheme.RED -> R.color.crd28
            AppTheme.NOTHING -> R.color.cnod28
        }
    }
}
