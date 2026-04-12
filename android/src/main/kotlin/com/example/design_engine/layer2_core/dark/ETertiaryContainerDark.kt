package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryContainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd35
            AppTheme.STANDARD -> R.color.cstd35
            AppTheme.BLUE -> R.color.cbd35
            AppTheme.GREEN -> R.color.cgd35
            AppTheme.RED -> R.color.crd35
            AppTheme.NOTHING -> R.color.cnod35
        }
    }
}
