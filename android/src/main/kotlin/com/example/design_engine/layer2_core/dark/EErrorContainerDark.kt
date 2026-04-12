package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EErrorContainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd43
            AppTheme.STANDARD -> R.color.cstd43
            AppTheme.BLUE -> R.color.cbd43
            AppTheme.GREEN -> R.color.cgd43
            AppTheme.RED -> R.color.crd43
            AppTheme.NOTHING -> R.color.cnod43
        }
    }
}
