package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerLowDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd11
            AppTheme.STANDARD -> R.color.cstd11
            AppTheme.BLUE -> R.color.cbd11
            AppTheme.GREEN -> R.color.cgd11
            AppTheme.RED -> R.color.crd11
            AppTheme.NOTHING -> R.color.cnod11
        }
    }
}
