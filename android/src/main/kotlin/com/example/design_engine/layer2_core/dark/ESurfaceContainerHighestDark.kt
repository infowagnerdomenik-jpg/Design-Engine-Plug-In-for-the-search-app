package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerHighestDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd14
            AppTheme.STANDARD -> R.color.cstd14
            AppTheme.BLUE -> R.color.cbd14
            AppTheme.GREEN -> R.color.cgd14
            AppTheme.RED -> R.color.crd14
            AppTheme.NOTHING -> R.color.cnod14
        }
    }
}
