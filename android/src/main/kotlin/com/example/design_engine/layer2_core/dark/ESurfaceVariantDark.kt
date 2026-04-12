package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceVariantDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd5
            AppTheme.STANDARD -> R.color.cstd5
            AppTheme.BLUE -> R.color.cbd5
            AppTheme.GREEN -> R.color.cgd5
            AppTheme.RED -> R.color.crd5
            AppTheme.NOTHING -> R.color.cnod5
        }
    }
}
