package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerLowestDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd13
            AppTheme.STANDARD -> R.color.cstd13
            AppTheme.BLUE -> R.color.cbd13
            AppTheme.GREEN -> R.color.cgd13
            AppTheme.RED -> R.color.crd13
            AppTheme.NOTHING -> R.color.cnod13
        }
    }
}
