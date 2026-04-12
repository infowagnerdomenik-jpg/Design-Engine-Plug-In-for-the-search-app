package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryContainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd27
            AppTheme.STANDARD -> R.color.cstd27
            AppTheme.BLUE -> R.color.cbd27
            AppTheme.GREEN -> R.color.cgd27
            AppTheme.RED -> R.color.crd27
            AppTheme.NOTHING -> R.color.cnod27
        }
    }
}
