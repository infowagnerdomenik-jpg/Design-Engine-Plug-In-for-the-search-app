package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd15
            AppTheme.STANDARD -> R.color.cstd15
            AppTheme.BLUE -> R.color.cbd15
            AppTheme.GREEN -> R.color.cgd15
            AppTheme.RED -> R.color.crd15
            AppTheme.NOTHING -> R.color.cnod15
        }
    }
}
